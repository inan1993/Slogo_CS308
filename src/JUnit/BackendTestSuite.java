package JUnit;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author loganrooper
 *
 */
public class BackendTestSuite {
	public static Test suite() {
        final TestSuite s = new TestSuite();
        s.addTestSuite(ExecutorTester.class);
//        s.addTestSuite(IntegrationTester.class);
        return s;
    }
}