package backend.node.operations;

import backend.node.types.ZeroArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class PI extends ZeroArgumentNode {

	@Override
	public Response run(ManipulateController mc) {
		this.setValue(Math.PI);
		return new Success(Math.PI);
	}
	
	
}