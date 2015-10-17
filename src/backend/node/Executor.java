package backend.node;

import java.awt.List;
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
				execute(n);
			}
		} else {
			//leaf
			return null;
		}
		return new Error("Unreachable code was... reached");
	}
}
