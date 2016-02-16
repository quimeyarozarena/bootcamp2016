
public class AbstractConnection {

    public Connect getConnection(String type) {

        if (type.equals("jdbc")) {
            return new JDBC_Connection();
        } else {
            return new Hibernate_Connection();
        }
    }
}
