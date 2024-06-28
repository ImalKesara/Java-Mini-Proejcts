package CarRentalSystem.Modal;

import java.sql.*;

public class Database {
    private String url = "jdbc:mysql://localhost:3306/carrentsystem";
    private String user = "root";
    private String pwd = "Wolf1234@";
    private Statement statement;
    private Connection connection;

    public Database(){
        try {
            connection = DriverManager.getConnection(url,user,pwd);
            statement = connection.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public Connection getConnection(){
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
