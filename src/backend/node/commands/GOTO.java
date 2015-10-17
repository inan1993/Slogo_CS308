package backend.node.commands;

import java.util.List;

import SharedObjects.WorkSpaceController;
import backend.node.Command;
import backend.node.Constant;
import backend.node.Node;

/**
 * @author loganrooper
 *
 */
public class GOTO extends Command {
	public GOTO(String name, int children) {
		super(name, children);
	}

	@Override
	public Node run(WorkSpaceController sharedHandle, List<Node> ln) {
		if (ln == null)
			throw new RuntimeException("Missing parameter.");
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
		return new Constant("Heading").setValue(prevHeading - newHeading);
	}
}