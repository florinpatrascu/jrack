import junit.framework.TestCase;
import org.jrack.Context;
import org.jrack.JRack;
import org.jrack.Rack;
import org.jrack.context.MapContext;
import org.jrack.utils.InvokerRack;

public class InvokerTest extends TestCase {
    public void testHelloWorld() throws Exception {
        JRack rack = new InvokerRack("org.jrack.*");
        Context<String> input = new MapContext<String>();
        input.with(Rack.PATH_INFO, "org.jrack.examples.HelloWorldRack");
        assertNotNull(rack.call(input));
    }

    public void testInvalidMask() throws Exception {
        assertMask(false, "org.other.*", "org.jrack.tests.HelloWorldRack");
        assertMask(false, "org.other.*", "org.otherproject.BadRack");
        assertMask(true, "org.jrack.examples.*", "org.jrack.examples.HelloWorldRack");
        assertMask(false, "org.*.nottests.*", "org.jrack.tests.HelloWorldRack");
    }

    private void assertMask(boolean exceptMatch, String mask, String clazz) {
        JRack rack = new InvokerRack(mask);
        Context<String> input = new MapContext<String>();
        input.with(Rack.PATH_INFO, clazz);
        Exception caught = null;

        try {
            rack.call(input);
        } catch (Exception e) {
            caught = e;
        }
        assertEquals(exceptMatch, caught == null);
    }
}
