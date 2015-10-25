package backend.node.operations;

import backend.node.ZeroArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class PI extends ZeroArgumentNode {
	public PI() {
		super();
	}

	@Override
	public Response run(ManipulateController mc) {
		this.setValue(Math.PI);
		return new Success(Math.PI);
	}
	
	
}