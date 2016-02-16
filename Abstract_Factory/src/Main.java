
public class Main {

    public static void main(String[] args) {

        AbstractConnection absConnection = new AbstractConnection();
        Connect connection = absConnection.getConnection("jdbc");
        String jdbc = connection.getConnection();

        Connect connection2 = absConnection.getConnection("hibernate");
        String hibernate = connection2.getConnection();

        System.out.println(jdbc);

        System.out.println(hibernate);
    }

}
