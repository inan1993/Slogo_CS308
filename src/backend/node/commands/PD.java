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
public class PD extends ZeroArgumentNode {

	@Override
	public Response run(ManipulateController sharedHandle) {
		sharedHandle.penDown();

		// return 1
		return new Success(1);
	}
}