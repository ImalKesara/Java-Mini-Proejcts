package CarRentalSystem.Modal;

import java.sql.*;

public class Database {
    private String url = "jdbc:mysql://localhost:3306/carrentsystem";
    private String user = "root";
    private String pwd = "Wolf1234@";
    private PreparedStatement preparedStatement;
    private Statement statement;

    public Database(){
        try {
            Connection connection = DriverManager.getConnection(url,user,pwd);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Statement getStatement() {
        return statement;
    }
}
