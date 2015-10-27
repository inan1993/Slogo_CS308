package backend.node.commands;

import backend.node.types.TwoArgumentNode;
import exceptions.WontImplementException;
import responses.Response;
import sharedobjects.ManipulateController;

public class ASKWITH extends TwoArgumentNode  {

	@Override
	public Response run(ManipulateController mc) {
		throw new WontImplementException("ASKWITH");
	}
}
