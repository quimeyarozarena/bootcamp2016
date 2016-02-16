import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {

    private Properties database;
    private Configuration cfg;
    private SessionFactory sessionFactory;

    public Properties getDatabase() {
        return database;
    }

    public void setDatabase(Properties database) {
        this.database = database;
    }

    public Configuration getCfg() {
        return cfg;
    }

    public void setCfg(Configuration cfg) {
        this.cfg = cfg;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String toString() {
        return "ULR DB: " + database.getProperty("hibernate.connection.url");
    }

}
