import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Behaviour {

    private List<File> recentFile;
    private static Behaviour behaviour = null;

    private Behaviour() {
        recentFile = new ArrayList<File>();

    }

    public static Behaviour getInstance() {
        if (behaviour == null) {
            behaviour = new Behaviour();
        }

        return behaviour;
    }

    public List<File> getRecentFile() {
        return recentFile;
    }

    public void setRecentFile(List<File> recentFile) {
        this.recentFile = recentFile;
    }

}
