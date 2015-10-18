package JUnit;
import backend.node.Constant;
import backend.node.Executor;
import backend.node.Node;
import backend.node.commands.FW;
import backend.parser.Parser;
import responses.Response;
import sharedobjects.ManipulateController;
import sharedobjects.Workspace;
import junit.framework.*;

/**
 * @author loganrooper
 *
 */
public class ExecutorTester extends TestCase {
	
	private Executor f;
	private ManipulateController mc;
	private Workspace ws;
	
	public void setUp() {
		ws = new Workspace();
		mc = new ManipulateController(ws);
		f = new Executor(mc);
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
	
	public void testAddition() {
		Node root = new FW("SUM");
		Node child = new FW("5").setValue(5);
		Node child2 = new FW("5").setValue(5);
		//add both
		root.addChild(child).addChild(child);
	}
	
	//  "fw 50"
	public void testSoftparse() {
		Parser p = new Parser(f, mc);
		Response s = p.parse("fw 50", "English");
		System.out.println(s.toString());
	}
}
