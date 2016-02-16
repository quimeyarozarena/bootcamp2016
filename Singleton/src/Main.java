public class Main {

    public static void main(String[] args) {

        try {
            SingletonExample con = SingletonExample.getConnectionSingleton();
            con.getdb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
