package BankingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Accounts {
    private Connection connection;
    private Scanner scanner ;
    public Accounts(Connection connection, Scanner scanner){
        this.connection = connection ;
        this.scanner = scanner;
    }

    public boolean account_exists(String a_email){
        String checkEmail_query = "SELECT * FROM accounts WHERE email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(checkEmail_query);
            preparedStatement.setString(1,a_email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return  false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
