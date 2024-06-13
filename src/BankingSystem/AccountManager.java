package BankingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountManager {
    private  Connection connection;
    private  Scanner scanner;
   public AccountManager(Connection connection, Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
   }

   public void debitMoney(long accountNumber){
       scanner.nextLine();
       System.out.println("Enter debit amount : ");
       double amount = scanner.nextDouble();
       scanner.nextLine();
       System.out.println("Enter security pin : ");
       String securityPin = scanner.nextLine();
       try {
           connection.setAutoCommit(false);
           if(accountNumber != 0){
               PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounts WHERE account_number = ? AND security_pin = ? ");
               preparedStatement.setLong(1,accountNumber);
               preparedStatement.setString(2,securityPin);
               ResultSet resultSet = preparedStatement.executeQuery();
               String trueSpin = resultSet.getString("security_pin");
               if(resultSet.next()){
                   double currentBalance = resultSet.getDouble("balance");
                   if(amount <= currentBalance){
                       String debit_query = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
                       PreparedStatement preparedStatement1 = connection.prepareStatement(debit_query);
                       preparedStatement1.setDouble(1,amount);
                       preparedStatement1.setLong(2,accountNumber);
                       int rowAffected = preparedStatement1.executeUpdate();
                       if(rowAffected > 0 ){
                           System.out.println("Rs " +  amount + " debited successfully !");
                           connection.commit();
                           connection.setAutoCommit(true);
                       }else{
                           System.out.println("Translation Failed");
                           connection.rollback();
                           connection.setAutoCommit(true);
                       }

                   }else{
                       System.out.println("Insufficient Balance!");
                   }
               }
           }else{
               System.out.println("invalid pin");
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

   }

   public void creditMoney(long accountNumber){
       scanner.nextLine();
       System.out.println("Enter credit amount to ");
       double amount = scanner.nextDouble();
       scanner.nextLine();
       System.out.println("Enter security pin");
       String securityPin = scanner.nextLine();
       try {
           connection.setAutoCommit(false);
           if(accountNumber != 0 ){
               PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM accounts WHERE account_number = ? AND security_pin = ?");
               preparedStatement.setLong(1,accountNumber);
               preparedStatement.setString(2,securityPin);
               ResultSet resultSet = preparedStatement.executeQuery();
               if(resultSet.next()){
                    String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ? ";
                    PreparedStatement preparedStatement1 = connection.prepareStatement(creditQuery);
                    preparedStatement1.setDouble(1,amount);
                    preparedStatement1.setLong(2,accountNumber);
                    int affectedRow = preparedStatement1.executeUpdate();
                    if(affectedRow > 0 ){
                        System.out.println("Rs" + amount + "credited successfully");
                        connection.commit();
                        connection.setAutoCommit(true);
                    }else{
                        System.out.println("Transaction failed");
                        connection.commit();
                        connection.rollback();
                    }

               }
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

   }

}
