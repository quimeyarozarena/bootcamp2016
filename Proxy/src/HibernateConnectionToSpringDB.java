import java.sql.Connection;
import java.sql.DriverManager;

public class HibernateConnectionToSpringDB extends Connect {

    Connection conn;

    String url = "jdbc:mysql://localhost:3306/";
    String db_name = "spring";
    String username = "root";
    String password = "root";

    public HibernateConnectionToSpringDB() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url + db_name, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
