package CarRentalSystem.Controller;

import CarRentalSystem.Modal.Admin;
import CarRentalSystem.Modal.Client;
import CarRentalSystem.Modal.Database;
import CarRentalSystem.Modal.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static  void main(String[] args){
        Database database = new Database();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Car Rental system");
        System.out.println("(-1) to create new account");
        String newAcc = sc.next();
        if(newAcc.equals("-1")){
            new AddnewAccount(0).operations(database,sc,null);
            return;
        }
        System.out.println("Enter your email :");
        String email = sc.next();
        System.out.println("Enter password");
        String password = sc.next();
        ArrayList<User> users = new ArrayList<>();

        try {
            User user;
            String checkData = "SELECT * FROM Users";
            ResultSet resultSet = database.getStatement().executeQuery(checkData);
            while (resultSet.next()){
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String em = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber");
                String pwd = resultSet.getString("password");
                int Type = resultSet.getInt("type");
                switch (Type){
                    case 0:
                        user = new Client();
                        break;
                    case 1:
                        user = new Admin();
                        break;
                    default:
                        System.out.println("Account doesn't exists");
                        return;
                }
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setPhoneNumber(phoneNumber);
                user.setPassword(pwd);
                user.setEmail(em);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        boolean userFound = false;

        for(User u : users){
            if(u.getEmail().equals(email) &&  u.getPassword().equals(password)){
                System.out.println("Welcome "+ u.getFirstName() + " !");
                u.showList(database,sc);
                userFound = true;
                break;
            }
        }
        if(!userFound){
            System.out.println("invalid email or password");
        }
    }
}
