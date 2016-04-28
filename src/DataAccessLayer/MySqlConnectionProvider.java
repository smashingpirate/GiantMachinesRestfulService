package DataAccessLayer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionProvider implements DBConnector {

    private final String URL = "jdbc:mysql://tviw6wn55xwxejwj.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306";
    private final String username = "vkm4w63uk2m37l9w";
    private final String password = "tqbhpotm7yd6zv5u";
    
    public Connection getConnection() throws SQLException {
        try {
            System.out.println("Connecting to database...");
            return DriverManager.getConnection(URL,username,password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
