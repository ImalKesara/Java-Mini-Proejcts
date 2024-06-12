package BankingSystem;

import java.sql.*;
import java.util.Scanner;

public class Accounts {
    private Connection connection;
    private Scanner scanner ;
    public Accounts(Connection connection, Scanner scanner){
        this.connection = connection ;
        this.scanner = scanner;
    }

    public long openAccount(String email){
        if(!account_exists(email)){
            String createAccount_query = "INSERT INTO accounts(account_number,full_name,email,balance,security_pin) " +
                    "VALUE (?,?,?,?,?)";
            scanner.nextLine();
            System.out.println("Enter your full name : ");
            String fullName = scanner.nextLine();
            System.out.println("Enter initial amount : ");
            double balance = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter security pin : ");
            String secuePin = scanner.nextLine();
            try {
                long AccountNumber = generateAccountNumber();
                PreparedStatement preparedStatement = connection.prepareStatement(createAccount_query);
                preparedStatement.setLong(1,AccountNumber);
                preparedStatement.setString(2,fullName);
                preparedStatement.setString(3,email);
                preparedStatement.setDouble(4,balance);
                preparedStatement.setString(5,secuePin);
                int resultSet = preparedStatement.executeUpdate();
                if(resultSet > 0){
                    return AccountNumber;
                }else{
                    throw new RuntimeException("Account creation failed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("Account Already Exist");
    }

    private long generateAccountNumber(){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT account_number FROM accounts ORDER BY account_number DESC  LIMIT 1");
            if(resultSet.next()){
                long last_accountNumber = resultSet.getLong("account_number");
                return last_accountNumber + 1;
            }else{
                return 10000100;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 10000100;
    }

    public long getAccountNumber(String getEmail){
        String accountEmailQuery = "SELECT account_number FROM accounts WHERE email = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(accountEmailQuery);
            preparedStatement.setString(1,getEmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getLong("account_number");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Account Number Doesn't Exist!");
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
