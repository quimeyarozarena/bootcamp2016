import java.io.File;
import junit.framework.Assert;
import org.junit.Test;

public class BehaviourTest {

    BehaviourController behaviourController = new BehaviourController();

    @Test
    public void whenRunAtFirstTimeThenListMustBeEmpty() {

        Assert.assertTrue(behaviourController.checkListEmpty());
    }

    @Test
    public void whenOpenAFileThenAddToList() {

        File file = new File("C:\\Users\\quimey.arozarena\\Desktop\\cv_formato_glb.doc");

        Assert.assertEquals(file, behaviourController.insertFileOpened(file));

    }

    @Test
    public void whenOpenFileAlreadyExistInListThenBumpToTheTop() {

        Assert.assertEquals("moved to top", behaviourController.moveToTopeIfFileIsInList());

    }

    @Test
    public void whenListIsFullThenRemoveOldestFile() {

        Assert.assertEquals(14, behaviourController.removeOldestFile());

    }
}
