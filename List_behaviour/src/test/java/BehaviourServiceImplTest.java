import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.List;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BehaviourServiceImplTest {

    private static BehaviourServiceImpl behaviourServiceImpl;
    private static Files files;
    private static List<File> filelist;
    private static File file;

    @BeforeClass
    public static void setUp() {
        behaviourServiceImpl = new BehaviourServiceImpl();
        files = mock(Files.class);
        filelist = mock(List.class);
        file = new File(Constants.fileLocation);

        when(files.getRecentFile()).thenReturn(filelist);
    }

    // I consider it, because when you run the application, the list is empty, so if list is empty it means that the
    // program was executed. Because of that I decided make singleton the files class.

    @Test
    public void whenRunAtFirstTimeThenListMustBeEmpty() {

        Assert.assertTrue(behaviourServiceImpl.checkListEmpty());
    }

    @Test
    public void whenOpenAFileThenAddToList() {

        Assert.assertEquals(file, behaviourServiceImpl.insertFileOpened(file));

    }

    @Test
    public void whenOpenFileAlreadyExistInListThenBumpToTheTop() {

        Assert.assertEquals(true, behaviourServiceImpl.moveToTopeIfFileIsInList());

    }

    @Test
    public void whenListIsFullThenRemoveOldestFile() {

        Assert.assertEquals(14, behaviourServiceImpl.removeOldestFile());

    }
}
