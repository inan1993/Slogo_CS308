import backend.*;
import backend.node.Constant;
import backend.node.Executor;
import backend.node.Node;
import backend.node.commands.FW;
import backend.parser.*;

/**
 * @author loganrooper
 *
 */
public class BackendTester {
	public static void main(String[] args) {
		//Parser p = new Parser();
		//p.parse("fw fw 10");
		Node root = new FW("FW");
		Node child = new FW("FW");
		Node leaf = new Constant("10");
		
		root.addChild(child);
		child.addChild(leaf);
		
		Executor exec = new Executor();
		exec.execute(root);
	}
}
