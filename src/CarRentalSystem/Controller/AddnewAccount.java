package CarRentalSystem.Controller;


import CarRentalSystem.Modal.Client;
import CarRentalSystem.Modal.Database;
import CarRentalSystem.Modal.Operations;
import CarRentalSystem.Modal.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddnewAccount implements Operations {

    private int accountType;

    public AddnewAccount(int accountType){
        this.accountType = accountType;
    }

    @Override
    public void operations(Database database,Scanner sc,User user) {
        System.out.println("Enter first name ");
        String firstName = sc.next();
        System.out.println("Enter last name");
        String lastName = sc.next();
        System.out.println("Enter Email");
        String email = sc.next();
        System.out.println("Enter phone number");
        String phoneNumber = sc.next();
        System.out.println("Enter password");
        String password = sc.next();
        System.out.println("confirm password");
        String confirmPassword = sc.next();
        while (!password.equals(confirmPassword)){
            System.out.println("Password doesn't match !!!");
            System.out.println("Enter password");
            password = sc.next();
            System.out.println("confirm password");
            confirmPassword = sc.next();

        }
        try {
            ResultSet resultSet = database.getStatement().executeQuery("SELECT COUNT(*);");
            resultSet.next();
//            String insert = "INSERT INTO `Users` (firstName`,`lastName`,`email`,`phoneNumber`,`password`,`type`) " +
//                    "VALUES('"+firstName+"','"+lastName+"','"+email+"','"+phoneNumber+"','"+password+"','"+accountType+"')";

            String insert = "INSERT INTO `Users` (`firstName`,`lastName`,`email`,`phoneNumber`,`password`,`type`) " +
                    "VALUES('" + firstName + "','" + lastName + "','" + email + "','" + phoneNumber + "','" + password + "','" + accountType + "')";

            database.getStatement().execute(insert);
            System.out.println("Account created successfully\n !");

            if(accountType == 0){
                user = new Client();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setPhoneNumber(phoneNumber);
                user.setPassword(password);
                user.showList(database,sc);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

