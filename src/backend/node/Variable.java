package backend.node;

import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

public class Variable extends SingleValuedObject {
	public Variable() {
		super();
	}

	protected Response run(ManipulateController mc) {
		return new Success(mc.getVariable(this.getName()).getDoubleValue());
	}
}
