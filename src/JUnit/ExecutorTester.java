package JUnit;

import backend.node.Constant;
import backend.node.Executor;
import backend.node.Node;
import backend.node.commands.FW;
import backend.node.operations.*;
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
	private Parser p;

	public void setUp() {
		ws = new Workspace();
		mc = new ManipulateController(ws);
		f = new Executor(mc);
		//p = new Parser(f, mc);
	}

	// "fw fw 10"
	public void testDoubleFW() {
		// This is to 'build' the syntax tree manually!
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
		// This is to 'build' the syntax tree manually!
		Node root = new FW("FW");
		Node child = new FW("FW");
		Node leaf = new Constant();
		leaf.setValue(50.0);
		root.addChild(child);
		child.addChild(leaf);

		Response a = f.execute(root);
		assertEquals(Double.parseDouble(a.toString()), 50.0);
	}

	// "sum 5 5"
	public void testAddition() {
		Node root = new SUM();
		Node child = new Constant().setValue(5);
		Node child2 = new Constant().setValue(5);
		// add both
		root.addChildren(child, child2);
		Response a = f.execute(root);
		assertEquals(Double.parseDouble(a.toString()), 10.0);
	}

	// "difference 5 5"
	public void testSubtraction() {
		Node root = new DIFFERENCE();
		Node child = new Constant().setValue(5);
		Node child2 = new Constant().setValue(5);
		// add both
		root.addChildren(child, child2);
		Response a = f.execute(root);
		assertEquals(Double.parseDouble(a.toString()), 0.0);
	}

	// "sum 5 sum 5 5"
	public void testSumNested() {
		Node root = new SUM();
		Node child0 = new Constant().setValue(5);
		root.addChild(child0);
		
		Node subroot = new SUM();
		Node child = new Constant().setValue(5);
		Node child2 = new Constant().setValue(5);
		// add both
		subroot.addChildren(child, child2);
		root.addChild(subroot);
		
		Response a = f.execute(root);
		assertEquals(Double.parseDouble(a.toString()), 15.0);
	}

	// "fw 50"
	public void testSoftparse() {
		Response s = p.parse("fw 50", "English");
		System.out.println(s.toString());
	}
	
	// sum sin pi sum cos pi tan pi
	public void testsincostanpi() {
		Node sin = new SIN();
		Node cos = new COS();
		Node tan = new TAN();
		Node pi = new PI();
		sin.addChild(pi);
		cos.addChild(pi);
		tan.addChild(pi);
		
		Node sum1 = new SUM();
		sum1.addChildren(cos, tan);
		Node sum2 = new SUM();
		sum2.addChildren(sin, sum1);
		
		Response a = f.execute(sum2);
		assertEquals(Double.parseDouble(a.toString()), 63.494436);
	}
	
	// tan pi
		public void testTan() {
			Node tan = new TAN();
			Node p = new Constant().setValue(360.0);		
			tan.addChild(p);
			Response a = f.execute(tan);
			assertEquals(Double.parseDouble(a.toString()) + 0.0, 0.0);
		}
}
