import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Hibernate_Connection extends Connect {

    public static SessionFactory sessionFactory;

    public Hibernate_Connection() {

        sessionFactory = null;
    }

    @Override
    public String getConnection() {
        try {
            Properties database = new Properties();
            database.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            database.setProperty("hibernate.connection.username", "root");
            database.setProperty("hibernate.connection.password", "root");
            database.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/spring");
            database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

            Configuration cfg = new Configuration().setProperties(database);

            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
                    .applySettings(cfg.getProperties());

            sessionFactory = cfg.buildSessionFactory(ssrb.build());
        } catch (Exception e) {
            System.out.println(e);
        }
        return "connected to hibernate";
    }

}
