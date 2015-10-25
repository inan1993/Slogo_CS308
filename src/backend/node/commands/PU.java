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
	public PU(String name, int children) {
		super();
	}

	@Override
	public Response run(ManipulateController sharedHandle) {
		sharedHandle.penUp();

		// return 1
		return new Success(1);
	}
}