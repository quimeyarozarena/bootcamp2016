public class Main {

    public static void main(String[] args) {

        try {
            SingletonExample con = SingletonExample.getInstance();
            con.getdb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
