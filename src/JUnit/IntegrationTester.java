/**
 * 
 */
package JUnit;

import backend.node.Executor;
import backend.parser.Parser;
import junit.framework.TestCase;
import responses.Response;

/**
 * @author loganrooper
 *
 */
public class IntegrationTester extends TestCase{
	
	private Parser p;
	
	public void setUp() {
		p = new Parser();
	}
	
	public void testIntegration() {
		Response s = p.parse("fw 50");
		
		assertEquals(Double.parseDouble(s.toString()), 50.0);
	}
}