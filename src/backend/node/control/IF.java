package backend.node.control;

import java.util.List;
import backend.node.ControlStructure;
import backend.node.Node;
import responses.Response;
import sharedobjects.ManipulateController;

public class IF extends ControlStructure {
	public IF() {
		super();
	}

	@Override
	public Response run(ManipulateController mc) {
		Response left = getChild(0).run(mc);
		if (left.toDouble() != 0) {
			return getChild(1).run(mc);
		}
		return left;
	}
}