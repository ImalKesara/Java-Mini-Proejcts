package CarRentalSystem.Controller;

import CarRentalSystem.Modal.Database;
import CarRentalSystem.Modal.Operations;
import CarRentalSystem.Modal.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddnewAdmin implements Operations {

    @Override
    public void operations(Database database, User user, Scanner sc) {
        System.out.println("enter first name ");
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
        int accType = 1;
        try {
            ResultSet resultSet = database.getStatement().executeQuery("SELECT COUNT(*);");
            resultSet.next();
            int ID = resultSet.getInt("COUNT(*)")-1;
            String insert = "INSERT INTO `Users` (`ID`,`firstName`,`lastName`,`email`,`phoneNumber`,`password`,`type`) " +
                    "VALUES('"+ID+"','"+firstName+"','"+lastName+"','"+email+"','"+phoneNumber+"','"+password+"','"+accType+"')";
            database.getStatement().execute(insert);
            System.out.println("Admin account created successfully\n !");


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
