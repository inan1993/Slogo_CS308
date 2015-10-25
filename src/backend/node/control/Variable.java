package backend.node.control;

import backend.node.types.ZeroArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

public class Variable extends ZeroArgumentNode {
	public Variable() {
		super();
	}

	public Response run(ManipulateController mc) {
		return new Success(mc.getVariable(this.getName()).getDoubleValue());
	}
}