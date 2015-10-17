package backend.node;

import java.util.List;
import java.util.ArrayList;
import backend.node.Node;
import responses.*;
import responses.Error;
import SharedObjects.*;
import exceptions.*;

/**
 * @author loganrooper
 *
 */
public class Executor {
	WorkSpaceController sharedHandle;
	
	public Executor() {
		sharedHandle = new WorkSpaceController();		
	}
	/**
	 * This is called multiple times if there are multiple roots in the syntax
	 * string.
	 * 
	 * @param root syntax tree node
	 * @return
	 */
	public Node execute(Node root) {
		if (root.hasChildren()) {
			List<Node> returnedNodes = new ArrayList<Node>();
			for (Node n : root.getChildren()) {
				returnedNodes.add(execute(n));
			}
			//Now, run this with recieved parameters
			root.run(sharedHandle, returnedNodes);
		} else {
			//leaf
			return root.run(sharedHandle, null);
		}
		return null;//todo: throw error
	}
}