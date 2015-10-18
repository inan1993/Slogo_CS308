package backend.node.commands;

import java.util.List;

import backend.node.Command;
import backend.node.Constant;
import backend.node.Node;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class TOWARDS extends Command {
	public TOWARDS(String name, int children) {
		super();
	}

	@Override
	public Node run(ManipulateController sharedHandle, List<Node> ln) {
		if (ln == null)
			throw new RuntimeException("Missing parameter(s).");
		if (ln.size() < 2)
			throw new RuntimeException(String.format("Expected 2 parameters, got: %d", ln.size()));

		// get headings
		double prevHeading = sharedHandle.getHeading();

		// get xy
		int x = ln.get(0).getIntegerValue();
		int y = ln.get(1).getIntegerValue();

		// turn
		sharedHandle.towards(x, y);

		// new heading
		double newHeading = ln.get(0).getDoubleValue();

		// return the delta
		return new Constant().setValue(prevHeading - newHeading);
	}
}