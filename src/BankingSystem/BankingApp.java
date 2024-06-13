package BankingSystem;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.cj.jdbc.Driver;

public class BankingApp {
    private static final String url = "jdbc:mysql://localhost:3306/banksystem";
    private static final String user = "root";
    private static final String pwd  = "Wolf1234@";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.err.println("Mysql JDBC Driver not found");
        }catch (Exception e){
            System.err.println("Could not load JDBC driver");
        }

        try{
            Connection connection = DriverManager.getConnection(url,user,pwd);
            Scanner scanner =  new Scanner(System.in);
            User user = new User(connection,scanner);
            AccountManager accountManager = new AccountManager(connection,scanner);
            Accounts accounts =  new Accounts(connection,scanner);

            String email;
            long accountNumber;
            boolean loop = true;


            while (loop){
                System.out.println("-------Welcome to Bank System------");
                System.out.println();
                System.out.println("1. Regitser");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.println("Enter ur choice");
                int choice = scanner.nextInt();
                switch(choice){
                    case 1:
                        user.register();
                        break;
                    case 2:
                        email =user.login();
                        if(email!=null){
                            System.out.println();
                            System.out.println("User loged in");
                            if(!accounts.account_exists(email)){
                                System.out.println();
                                System.out.println("1. Open a new Bank Account");
                                System.out.println("2. Exit");
                                if(scanner.nextInt()==1){
                                    accountNumber = accounts.openAccount(email);
                                    System.out.println("Account creation successfully");
                                    System.out.println("Your account number is " + accountNumber);
                                }else{
                                    break;
                                }
                            }
                            //if exists
                            accountNumber = accounts.getAccountNumber(email);
                            int choiceTwo = 0;
                            while (choiceTwo != 5){
                                System.out.println();
                                System.out.println("1. Debit Money");
                                System.out.println("2. Credit Money");
                                System.out.println("3. Transfer Money");
                                System.out.println("4. Check balance");
                                System.out.println("5. Exit");
                                choiceTwo = scanner.nextInt();
                                switch (choiceTwo){
                                    case 1:
                                        accountManager.debitMoney(accountNumber);
                                        break;
                                    case 2:
                                        accountManager.creditMoney(accountNumber);
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        break;
                                    case 5:
                                        choiceTwo = 5;
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                        break;
                                }
                            }
                        }else{
                            System.out.println("Please register ");
                        }
                        break;
                    case 3:
                        System.out.println("Thank you for using banking system");
                        System.out.println("Exiting the system");
                        loop =false;
                        break;
                    default:
                        System.out.println("Please check ur input");
                        break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

