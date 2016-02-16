import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonExample {

    private static Connection conn = null;

    public static SingletonExample singletonExample = null;

    String url = "jdbc:mysql://localhost:3306/";
    String db_name = "spring";
    String username = "root";
    String password = "root";

    private SingletonExample() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url + db_name, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SingletonExample getConnectionSingleton() {

        if (singletonExample == null) {
            singletonExample = new SingletonExample();
        }
        return singletonExample;
    }

    public void getdb() {

        System.out.println("db has been connected");

    }
}
