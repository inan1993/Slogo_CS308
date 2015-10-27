package backend.node.display;

import backend.node.types.ZeroArgumentNode;
import exceptions.WontImplementException;
import responses.Response;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class CLEARSTAMPS extends ZeroArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		throw new WontImplementException("CLEARSTAMPS");
	}
}