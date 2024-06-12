package BankingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User implements Userfunc{

    private Connection connection;
    private Scanner scanner;
    public User(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }


    public String login(){
        scanner.nextLine();
        System.out.println("Enter Email :-");
        String email = scanner.nextLine();
        System.out.println("Enter password :-");
        String pwd  = scanner.nextLine();
        String login_query  = "SELECT * FROM user WHERE email = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(login_query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,pwd);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return email;
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }


    public void register(){
        scanner.nextLine();
        System.out.println("Full name : -");
        String fullname = scanner.nextLine();
        System.out.println("Email :-");
        String email = scanner.nextLine();
        System.out.println("Password : -");
        String pwd = scanner.nextLine();
        if(user_exists(email)){
            System.out.println("User Already Exists for this Email Address!!");
            return;
        }else{
            String register_query = "INSERT INTO user(full_name,email,password) VALUES (?,?,?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(register_query);
                preparedStatement.setString(1,fullname);
                preparedStatement.setString(2,email);
                preparedStatement.setString(3,pwd);
                int affectedRows  = preparedStatement.executeUpdate();
                if(affectedRows > 0 ){
                    System.out.println("Registration successfully");
                }else{
                    System.out.println("Registration Failed");
                }

            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
    }

    public boolean user_exists(String email){
        String query = "SELECT * FROM user WHERE email = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else {
                return false;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
