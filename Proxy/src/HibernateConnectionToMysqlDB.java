import java.sql.Connection;
import java.sql.DriverManager;

public class HibernateConnectionToMysqlDB extends Connect {

    Connection conn;

    String url = "jdbc:mysql://localhost:3306/";
    String db_name = "mysql";
    String username = "root";
    String password = "root";

    public HibernateConnectionToMysqlDB() {

        try {
            Thread.sleep(3000);

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url + db_name, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
