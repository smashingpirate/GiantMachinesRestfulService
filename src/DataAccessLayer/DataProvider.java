package DataAccessLayer;

import Objects.Factory;
import Objects.PropertiesExtractor;
import com.google.inject.Inject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataProvider <T extends PropertiesExtractor>{

    DBConnector connector;
    private final String driver = "com.mysql.jdbc.Driver";

    @Inject
    public DataProvider(DBConnector connector){
            this.connector = connector;
    }

    public List<T> getData(String query, Factory<T> factory){
        List<T> data = new ArrayList<T>();
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = connector.getConnection();
            if (conn == null){
                System.out.print("Connection is empty");
                return null;
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                T obj = factory.create();
                ResultSetMetaData rsmd = rs.getMetaData();
                data.add((T)obj.extract(rs, rsmd));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       return data;
    }
}
