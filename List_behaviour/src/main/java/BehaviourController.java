import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class BehaviourController {

    private Behaviour behaviour;

    public BehaviourController() {
        behaviour = Behaviour.getInstance();
    }

    public boolean checkListEmpty() {

        return behaviour.getRecentFile().isEmpty();

    }

    public File insertFileOpened(File file) {

        if (!isFileClosed(file)) {
            behaviour.getRecentFile().add(file);
        }

        return behaviour.getRecentFile().get(behaviour.getRecentFile().size() - 1);
    }

    public boolean moveToTopeIfFileIsInList() {

        boolean move = false;
        File file = new File("C:\\Users\\quimey.arozarena\\Desktop\\cv_formato_glb.doc");
        if (!isFileClosed(file)) {

            if (behaviour.getRecentFile().contains(file)) {

                behaviour.getRecentFile().remove(file);
                behaviour.getRecentFile().add(behaviour.getRecentFile().size(), file);
                move = true;
            }
            return move;
        }

        return move;
    }

    public int removeOldestFile() {

        int size = behaviour.getRecentFile().size();
        if (size == 15) {
            behaviour.getRecentFile().remove(0);
            size = behaviour.getRecentFile().size();
        }

        return size;
    }

    // If file is open by other processes, you will get an exception
    private boolean isFileClosed(File file) {
        boolean closed;
        FileChannel channel = null;
        try {
            channel = new RandomAccessFile(file, "file").getChannel();
            closed = true;
        } catch (Exception ex) {
            closed = false;
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return closed;
    }
}
