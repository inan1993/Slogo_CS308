package backend.node;

import responses.Response;
import responses.Success;
import sharedobjects.ITurtleLambda;
import sharedobjects.ManipulateController;
import sharedobjects.Turtle;

public class DUVALL extends Node {

	@Override
	public Response run(ManipulateController mc) {
		mc.tellDuvall2Dance();
		return new Success("He be Dancin'");
	}

}
