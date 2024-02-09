import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbFunctions {

    public static Connection connect_to_db() {
        Connection connection = null;

        try {
            String url = "jdbc:postgresql://localhost:5432/tutdb";
            String user = "postgres";
            String password = "admin";

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Veritabanına başarıyla bağlandı.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void createTable(Connection connection, String table_name) {
        try (Statement statement = connection.createStatement()) {
            String query = "CREATE TABLE IF NOT EXISTS " + table_name +
                    " (empid SERIAL, name varchar(200), address varchar(200), PRIMARY KEY(empid))";
            statement.executeUpdate(query);
            System.out.println("Tablo Oluşturuldu..");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert_row(Connection connection, String table_name, String data) {
        try (Statement statement = connection.createStatement()) {
            // Veriyi virgül ile ayır ve adı, adresi al
            String[] parts = data.split(",");

            if (parts.length == 2) {
                String name = parts[0].trim();
                String address = parts[1].trim();

                // Veritabanına ekle
                String query = String.format("INSERT INTO %s (name, address) VALUES ('%s', '%s');", table_name, name, address);
                statement.executeUpdate(query);
                System.out.println("Satır Eklendi..");
            } else {
                System.out.println("Hatalı veri formatı.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
