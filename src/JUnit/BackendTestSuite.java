package JUnit;
import junit.framework.*;

/**
 * @author loganrooper
 *
 */
public class BackendTestSuite {
	public static Test suite() {
        final TestSuite s = new TestSuite();
        s.addTestSuite(BackendTester.class);
        return s;
    }
}
