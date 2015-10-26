package backend.node.display;

import backend.node.types.OneArgumentNode;
import exceptions.WontAddException;
import responses.Response;
import responses.Success;
import sharedobjects.IPenLambda;
import sharedobjects.ManipulateController;
import sharedobjects.Pen;

/**
 * @author loganrooper
 *
 */
public class SETSH extends OneArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		throw new WontAddException();
	}
}