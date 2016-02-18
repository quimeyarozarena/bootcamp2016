
public class ConnectionDirector {

    private ConnectionBuilder connectionBuilder = null;

    public ConnectionDirector(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    public void buildConnection() {
        connectionBuilder.buildProperties();
        connectionBuilder.buildConfiguration();
    }

    public Object getConnection() {
        System.out.println("connected successfully");
        return connectionBuilder.getConnection();
    }

}
