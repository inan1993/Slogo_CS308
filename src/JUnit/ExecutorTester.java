package JUnit;
import backend.node.Constant;
import backend.node.Executor;
import backend.node.Node;
import backend.node.commands.FW;
import responses.Response;
import junit.framework.*;

/**
 * @author loganrooper
 *
 */
public class ExecutorTester extends TestCase {
	
	private Executor f;
	
	public void setUp() {
	//	f = new Executor();
	}
	
	// "fw fw 10"
	public void testDoubleFW() {
		//This is to 'build' the syntax tree manually!
		Node root = new FW("FW");
		Node child = new FW("FW");
		Node leaf = new Constant();
		leaf.setName("10");
		leaf.setValue(10);
		root.addChild(child);
		child.addChild(leaf);
		
		Response a = f.execute(root);
		assertEquals(Double.parseDouble(a.toString()), 10.0);
	}
	
	// "fw fw 50"
	public void testDoubleFW2() {
		//This is to 'build' the syntax tree manually!
		Node root = new FW("FW");
		Node child = new FW("FW");
		Node leaf = new Constant();
		leaf.setValue(50.0);
		root.addChild(child);
		child.addChild(leaf);
		
		Response a = f.execute(root);
		assertEquals(Double.parseDouble(a.toString()), 50.0);
	}
}
