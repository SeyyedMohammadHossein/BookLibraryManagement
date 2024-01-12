package Sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnection {
    private java.sql.Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public SqlConnection(String address, String username, String password){
        try {
            connection = DriverManager.getConnection(address, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getResultSet(String tableName){
        try {
            resultSet = statement.executeQuery("SELECT * FROM " + tableName);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
