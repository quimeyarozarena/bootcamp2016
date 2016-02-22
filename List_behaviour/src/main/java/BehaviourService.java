import java.io.File;

public interface BehaviourService {

    public boolean checkListEmpty();

    public File insertFileOpened(File file);

    public boolean moveToTopeIfFileIsInList();

    public int removeOldestFile();
}
