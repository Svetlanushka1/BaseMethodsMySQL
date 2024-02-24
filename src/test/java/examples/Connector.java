package examples;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Connector {
    String url = "jdbc:mysql://db4free.net:3306/telran40";
    String user = "telran40";
    String password = "telran40";

    Connection connection = DriverManager.getConnection(url, user, password);

    public Connector() throws SQLException {
    }

    public void connect(){
        // assume that conn is an already created JDBC connection (see previous examples)
        Statement stmt = null;
        ResultSet rs = null;
        try {

            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT foo FROM bar");
            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...
            if (stmt.execute("SELECT foo FROM bar")) {
                rs = stmt.getResultSet();
            }
            // Now do something with the ResultSet ....
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
    }
}

