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

   public void tranferMoney(long accountNumber){
        scanner.nextLine();
        System.out.println("Enter person account number");
        long tranferPersonAccountNumber = scanner.nextLong();

        System.out.println("Enter amount");
        double amount = scanner.nextDouble();
       scanner.nextLine();
       System.out.println("Enter secuirty pin");
       String securityPin = scanner.nextLine();
       try {
           connection.setAutoCommit(false);
           if(accountNumber != 0){
               PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounts WHERE account_number = ? AND security_pin = ?");
               preparedStatement.setLong(1,accountNumber);
               preparedStatement.setString(2,securityPin);
               ResultSet resultSet = preparedStatement.executeQuery();
               if (resultSet.next()){
                   double currentBalance = resultSet.getDouble("balance");
                   if(amount <= currentBalance){
                       //reduce
                       String tranferQueryR = "UPDATE accounts SET balance = balance - ? WHERE account_number = ? ";
                       //plus
                       String tranferQueryP = "UPDATE accounts SET balance = balance + ? WHERE account_number = ? ";
                       PreparedStatement preparedStatement1 = connection.prepareStatement(tranferQueryR);
                       PreparedStatement preparedStatement2 = connection.prepareStatement(tranferQueryP);

                       //preparedStatement1
                       preparedStatement1.setDouble(1,amount);
                       preparedStatement1.setLong(2,accountNumber);
                       int affectedRowOne  = preparedStatement1.executeUpdate();

                       //preparedStatement2

                       preparedStatement2.setDouble(1,amount);
                       preparedStatement2.setLong(2,tranferPersonAccountNumber);
                       int affectedRowTwo = preparedStatement2.executeUpdate();

                       if(affectedRowOne > 0 && affectedRowTwo > 0){
                           System.out.println("Money Transfer successfully");
                           connection.commit();
                           connection.setAutoCommit(true);
                       }else{
                           System.out.println("Transfer failed");
                           //connection.commit();
                           connection.rollback();
                           connection.setAutoCommit(true);
                       }

                   }else{
                       System.out.println("Insufficient amount");
                   }
               }else{
                   System.out.println("invalid security pin");
               }
           }else{
               System.out.println("invalid account number");
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }


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

   public void viewBalance(long accountNumber){
       scanner.nextLine();
       System.out.println("Enter your security pin");
       String secuirtyPin = scanner.nextLine();
       try {
           connection.setAutoCommit(false);
           PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounts WHERE account_number = ? AND security_pin = ?");
           preparedStatement.setLong(1,accountNumber);
           preparedStatement.setString(2,secuirtyPin);
           ResultSet resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
               double currentBalance = resultSet.getDouble("balance");
               System.out.println("Your balance is " + currentBalance);
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
