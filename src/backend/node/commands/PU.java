/**
 * 
 */
package backend.node.commands;

import backend.node.ZeroArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class PU extends ZeroArgumentNode {

	@Override
	public Response run(ManipulateController sharedHandle) {
		sharedHandle.penUp();

		// return 1
		return new Success(1);
	}
}