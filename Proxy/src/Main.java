public class Main {

    public static void main(String[] args) {

        Proxy proxy = new Proxy();
        HibernateConnectionToSpringDB hc = new HibernateConnectionToSpringDB();
        hc.doConnection();

        proxy.doConnection();

    }

}
