import java.io.File;
import java.util.ArrayList;
import java.util.List;

//made this class to get only one instance of an object in order to check all behaviour apply to a one object.
public class Files {

    private List<File> recentFile;
    private static Files behaviour = null;

    private Files() {
        recentFile = new ArrayList<File>();
    }

    public static Files getInstance() {
        if (behaviour == null) {
            behaviour = new Files();
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
