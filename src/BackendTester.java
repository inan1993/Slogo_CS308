import backend.*;
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
		//p.parse("fw 50");
		Node root = new FW("FW", 50);
		//should I put nodes in here^? 
	}
}
