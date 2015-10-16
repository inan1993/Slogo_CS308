package backend.executor;

import java.awt.List;
import java.util.ArrayList;
import backend.node.Node;
import responses.Response;
import SharedObjects.*;

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
		
		
		if (root.hasChildren()) {
			for (Node n : root.getChildren()) {
				
			}
		}
		

		return null;
	}

}
