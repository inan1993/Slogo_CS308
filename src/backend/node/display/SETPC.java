package backend.node.display;

import backend.node.types.OneArgumentNode;
import responses.Response;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class SETPC extends OneArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		// Call mc.setBG()
		return null;
	}
}