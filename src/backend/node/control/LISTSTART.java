package backend.node.control;

import backend.node.Node;
import backend.node.types.ControlStructure;
import responses.*;
import responses.Error;
import sharedobjects.ManipulateController;

public class LISTSTART extends ControlStructure {
	@Override
	public Response run(ManipulateController mc) {
		// Just run each node and return the last value
		Response s = null;
		for (Node n : getChildren()) {
			s = n.run(mc);
		}

		if (s == null)
			return new Error("Messsage");

		return s;
	}
}