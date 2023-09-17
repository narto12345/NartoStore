package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class provides the object that allows you to connect to the SQLite
 * database
 */
public class ConnectionSQLite {

    private static final String URL = "jdbc:sqlite:narto_store.db";

    /**
     * Returns the connection to the SQLite database
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    /**
     * Closes a ResultSet object
     * @param rs ResultSet object to close
     */
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    /**
     * Closes a PreparedStatement object
     * @param ps PreparedStatement object to close
     */
    public static void close(PreparedStatement ps) {
        try {
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    /**
     * Close a connection to a database
     * @param conn Reference to the Connection object that you want to close
     */
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}