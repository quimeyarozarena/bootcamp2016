import junit.framework.Assert;
import org.junit.Test;

public class ExampleTest {

    Example example = new Example();

    @Test
    public void getHelloWorldTest() {

        Assert.assertEquals(example.getHelloWorld(), "Hello World");
        int x = 1;

    }

}
