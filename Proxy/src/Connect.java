import java.util.Date;

public abstract class Connect {

    public void doConnection() {
        System.out.println("connected successfully! " + this.getClass().getSimpleName() + " at " + new Date());

    }
}
