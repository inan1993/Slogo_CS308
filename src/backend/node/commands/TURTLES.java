/**
 * 
 */
package backend.node.commands;

import backend.node.types.ZeroArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class TURTLES extends ZeroArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		return new Success(mc.getActiveTurtleIDS().size());
	}
}