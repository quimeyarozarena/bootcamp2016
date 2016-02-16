import java.util.Date;

public class Proxy {

    HibernateConnectionToMysqlDB hibernateConnection;

    public Proxy() {
        System.out.println("Creating at: " + new Date());
    }

    public void doConnection() {

        if (hibernateConnection == null) {
            hibernateConnection = new HibernateConnectionToMysqlDB();
        }

        hibernateConnection.doConnection();
    }
}
