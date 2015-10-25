package backend.node.commands;

import java.util.List;

import backend.node.Node;
import backend.node.types.Command;
import backend.node.types.Constant;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class HOME extends Command {

	public Response run(ManipulateController mc) {
		Response s = mc.home();
		double distanceMoved = Double.parseDouble(s.toString());
		return new Success(distanceMoved);
	}
}