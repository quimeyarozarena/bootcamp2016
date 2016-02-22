import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class BehaviourServiceImpl implements BehaviourService {

    private Files files;

    public BehaviourServiceImpl() {
        files = Files.getInstance();
    }

    public boolean checkListEmpty() {

        return files.getRecentFile().isEmpty();

    }

    public File insertFileOpened(File file) {

        if (!isFileClosed(file)) {
            files.getRecentFile().add(file);
        }

        return files.getRecentFile().get(files.getRecentFile().size() - 1);
    }

    public boolean moveToTopeIfFileIsInList() {

        boolean move = false;
        File file = new File(Constants.fileLocation);
        if (!isFileClosed(file)) {

            if (files.getRecentFile().contains(file)) {

                files.getRecentFile().remove(file);
                files.getRecentFile().add(files.getRecentFile().size(), file);
                move = true;
            }
            return move;
        }

        return move;
    }

    public int removeOldestFile() {

        int size = files.getRecentFile().size();
        if (size == 15) {
            files.getRecentFile().remove(0);
            size = files.getRecentFile().size();
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
