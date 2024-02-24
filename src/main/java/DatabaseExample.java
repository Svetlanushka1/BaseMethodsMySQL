import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseExample {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://your-mysql-host:3306/telran40";
    private static final String USER = "telran40";
    private static final String PASSWORD = "telran40";

    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
                createTables(connection);
                insertSampleData(connection);
                executeQueries(connection);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        // Create tables
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS personal (" +
                    "person_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "first_name VARCHAR(50)," +
                    "last_name VARCHAR(50)," +
                    "birth_date DATE," +
                    "address VARCHAR(100))");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS customer (" +
                    "customer_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "person_id INT," +
                    "email VARCHAR(100)," +
                    "phone_number VARCHAR(20)," +
                    "FOREIGN KEY (person_id) REFERENCES personal(person_id))");

            // Similar statements for other tables
        }
    }

    private static void insertSampleData(Connection connection) throws SQLException {
        // Insert sample data
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO personal (first_name, last_name, birth_date, address) " +
                    "VALUES ('John', 'Doe', '1990-01-01', '123 Main St'), " +
                    "('Jane', 'Smith', '1985-05-15', '456 Oak St')");

            statement.executeUpdate("INSERT INTO customer (person_id, email, phone_number) " +
                    "VALUES (1, 'john.doe@example.com', '555-1234'), " +
                    "(2, 'jane.smith@example.com', '555-5678')");

            // Similar statements for other tables
        }
    }

    private static void executeQueries(Connection connection) throws SQLException {
        // Execute queries
        try (Statement statement = connection.createStatement()) {
            // Example query using JOIN
            ResultSet resultSet = statement.executeQuery("SELECT c.customer_id, CONCAT(p.first_name, ' ', p.last_name) AS customer_name, " +
                    "o.order_id, o.order_date, o.total_amount " +
                    "FROM customer c " +
                    "JOIN order_table o ON c.customer_id = o.customer_id " +
                    "JOIN personal p ON c.person_id = p.person_id");

            // Process the result set
            while (resultSet.next()) {
                // Retrieve data from the result set
                int customerId = resultSet.getInt("customer_id");
                String customerName = resultSet.getString("customer_name");
                int orderId = resultSet.getInt("order_id");
                String orderDate = resultSet.getString("order_date");
                double totalAmount = resultSet.getDouble("total_amount");

                // Print or process the retrieved data as needed
                System.out.println("Customer ID: " + customerId + ", Customer Name: " + customerName +
                        ", Order ID: " + orderId + ", Order Date: " + orderDate + ", Total Amount: " + totalAmount);
            }
        }
    }
}
