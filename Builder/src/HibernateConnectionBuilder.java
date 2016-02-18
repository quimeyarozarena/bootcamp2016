import java.util.Properties;
import org.hibernate.cfg.Configuration;

public class HibernateConnectionBuilder implements ConnectionBuilder {

    HibernateConnection hibernateConnection;

    public HibernateConnectionBuilder() {
        hibernateConnection = new HibernateConnection();
    }

    @Override
    public void buildProperties() {

        Properties database = new Properties();
        database.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        database.setProperty("hibernate.connection.username", "root");
        database.setProperty("hibernate.connection.password", "root");
        database.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/spring");
        database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        hibernateConnection.setDatabase(database);
    }

    @Override
    public void buildConfiguration() {

        Configuration cfg = new Configuration().setProperties(hibernateConnection.getDatabase());
        hibernateConnection.setCfg(cfg);

    }

    @Override
    public HibernateConnection getConnection() {
        return hibernateConnection;
    }

}
