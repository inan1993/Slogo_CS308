package backend.node.control;

import java.util.List;

import backend.node.Constant;
import backend.node.ControlStructure;
import backend.node.Executor;
import backend.node.Node;
import responses.Response;
import sharedobjects.ManipulateController;


public class LISTSTART extends ControlStructure {
	@Override
	public Response run(ManipulateController mc) {
		// Just run each node and return the last value
		Response s;
		for (Node n : getChildren()) {
			s = n.run(mc);
		}
		if (s == null)
			s = new Error("Messsage");
		
		return s;
	}
}
