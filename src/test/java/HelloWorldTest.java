import junit.framework.TestCase;
import org.jrack.RackResponse;
import org.jrack.examples.HelloWorldRack;

public class HelloWorldTest extends TestCase {
    public void testHelloWorld() throws Exception {
        assertTrue(new HelloWorldRack().call(null) instanceof RackResponse);
    }
}
