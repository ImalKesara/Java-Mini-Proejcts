package BankingSystem;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.cj.jdbc.Driver;

public class BankingApp {
    private static final String url = "jdbc:mysql://localhost:3306/hospital";
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
                        System.out.println("user class");
                        break;
                    case 2:
                        System.out.println("login class");
                        break;
                    case 3:
                        loop =false;

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

