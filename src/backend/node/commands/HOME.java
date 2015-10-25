package backend.node.commands;

import java.util.List;

import backend.node.Command;
import backend.node.Constant;
import backend.node.Node;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class HOME extends Command {
	public HOME(String name, int children) {
		super();
	}

	public Response run(ManipulateController mc) {
		Response s = mc.home();
		double distanceMoved = Double.parseDouble(s.toString());
		return new Success(distanceMoved);
	}
}