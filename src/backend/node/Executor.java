package backend.node;

import java.util.List;
import java.util.ArrayList;
import backend.node.Command;
import backend.node.Node;
import backend.node.SingleValuedObject;
import responses.*;
import responses.Error;
import sharedobjects.*;
import exceptions.*;

/**
 * @author loganrooper
 *
 */
public class Executor {
	ManipulateController sharedHandle;

	public Executor(ManipulateController manipulateController) {
		sharedHandle = manipulateController;
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
		return new Success(String.format("%f", finished.getDoubleValue()));
	}
	
	private Node recurse(Node root) {
		if (root.hasChildren()) {
			List<Node> returnedNodes = new ArrayList<Node>();
			for (Node n : root.getChildren()) {
				returnedNodes.add(recurse(n));
			}
			
			// Now, run this with our received parameters
			if (root instanceof Command) {
				return ((Command) root).run(sharedHandle, returnedNodes);
			} else if (root instanceof Operation) {
				return ((Operation) root).run(returnedNodes);
			} else { 
				//We've got a SVO here, that wasn't a leaf...
				throw new RuntimeException("Invalid number of children for this node!");
			}
		} else {
			// leaf - make sure it's a SVO not a command
			if (root.getClass().getSuperclass().equals(SingleValuedObject.class))
				return root;
			else 
				//We've got a command here, that was a leaf...
				throw new RuntimeException("Invalid number of children for this node!");
		}
	}
}