package backend.node;

import java.util.List;
import java.util.ArrayList;
import backend.node.Command;
import backend.node.Node;
import backend.node.OneArgumentNode;
import backend.node.commands.FD;
import responses.*;
import responses.Error;
import sharedobjects.*;
import exceptions.*;

/**
 * @author loganrooper
 *
 */
public class Executor {
	private ManipulateController sharedHandle;

	public Executor(ManipulateController manipulateController) {
		sharedHandle = manipulateController;
	}

	/**
	 * This is called multiple times if there are multiple roots in the syntax
	 * string.
	 * 
	 * @param root
	 *            syntax tree node
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

			//todo: run.
			return null;
			
		} 
		//todo: run
		return null;
	}

	public ManipulateController getManipulateController() {
		return sharedHandle;
	}
}