package backend.node;

import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

public class Constant extends ZeroArgumentNode {
	public Constant() {
		super();
	}

	@Override
	protected Response run(ManipulateController mc) {
		return new Success(this.getDoubleValue());
	}
}