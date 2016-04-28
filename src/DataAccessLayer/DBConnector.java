package DataAccessLayer;

import java.sql.Connection;
import java.sql.SQLException;

interface DBConnector {

    abstract Connection getConnection() throws SQLException;

}
