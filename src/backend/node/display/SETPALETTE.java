package backend.node.display;

import backend.node.FourArgumentNode;
import responses.Response;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class SETPALETTE extends FourArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		// Call mc.setBG()
		return null;
	}
}