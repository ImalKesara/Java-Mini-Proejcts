package BankingSystem;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

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

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

