package backend.node.commands;

import java.util.List;

import backend.node.Command;
import backend.node.Constant;
import backend.node.Node;
import responses.Response;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class HOME extends Command {
	public HOME(String name, int children) {
		super();
	}

	@Override
	public Node run(ManipulateController sharedHandle, List<Node> ln) {
		if (ln == null)
			throw new RuntimeException("Missing parameter.");
		
		Response s = sharedHandle.home();
		double distanceMoved = Double.parseDouble(s.toString());
		return new Constant().setValue(distanceMoved);
	}
}