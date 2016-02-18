
public class Main {

    public static void main(String[] args) {

        ConnectionBuilder connectionBuilder = new HibernateConnectionBuilder();
        ConnectionDirector connectionDirector = new ConnectionDirector(connectionBuilder);
        connectionDirector.buildConnection();
        HibernateConnection hc = (HibernateConnection) connectionDirector.getConnection();
        System.out.println(hc);
    }

}
