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
public class HT extends ZeroArgumentNode {

	@Override
	public Response run(ManipulateController sharedHandle) {
		sharedHandle.hideTurtle();

		// return 1
		return new Success(1);
	}
}