package backend.node.display;

import backend.node.types.OneArgumentNode;
import responses.Response;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class SETSH extends OneArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		// Call mc.setBG()
		return null;
	}
}