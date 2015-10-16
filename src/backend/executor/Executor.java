package backend.executor;

import java.awt.List;
import java.util.ArrayList;
import backend.node.Node;
import responses.Response;
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
				switch (n.getClass().getName()) {
				case "backend.node.Command":
					//do command stuff
					System.out.println("Command");
				case "backend.node.ControlStructure":
					throw new NotImplementedException();
				case "backend.node.Variable":
					throw new NotImplementedException();
				}		
			}
		}
		

		return null;
	}

}
