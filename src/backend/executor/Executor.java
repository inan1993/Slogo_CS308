package backend.executor;

import backend.node.Node;
import responses.Response;

/**
 * @author loganrooper
 *
 */
public class Executor {

	/**
	 * This is called multiple times if there are multiple roots in the syntax
	 * string.
	 * 
	 * @param root syntax tree node
	 * @return
	 */
	public Response execute(Node root) {

		while (root.hasChildren()) {
			
		}

		return null;
	}

}
