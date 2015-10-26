/**
 * 
 */
package backend.node.commands;

import backend.node.types.OneArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class TELL extends OneArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		// Call setTurtleIDS(array of ints) -> this should create turtles as well
		// If only one argument then I'll create a range 0->x
		return new Success(0);
	}
}