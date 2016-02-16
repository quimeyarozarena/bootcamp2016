import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Connection extends Connect {

    Connection conn;

    String url = "jdbc:mysql://localhost:3306/";
    String db_name = "spring";
    String username = "root";
    String password = "root";

    public JDBC_Connection() {
        conn = null;
    }

    @Override
    public String getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url + db_name, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "connected to JDBC";
    }

}
