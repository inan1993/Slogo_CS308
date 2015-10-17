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
	public Response execute(Node root) {
		Node finished = recurse(root);
		return new Success(String.format("%f", finished.getValue()));
	}
	
	private Node recurse(Node root) {
		if (root.hasChildren()) {
			List<Node> returnedNodes = new ArrayList<Node>();
			for (Node n : root.getChildren()) {
				returnedNodes.add(recurse(n));
			}
			// Now, run this with recieved parameters
			return root.run(sharedHandle, returnedNodes);
		} else {
			// leaf
			return root.run(sharedHandle, new ArrayList<Node>());
		}
	}
}