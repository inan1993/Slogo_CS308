
package backend.node.commands;

import java.util.List;

import backend.node.Command;
import backend.node.Node;
import sharedobjects.ManipulateController;


/**
 * @author loganrooper
 *
 */
public class BK extends Command {
	public BK(String name, int children) {
		super();
	}

	@Override
	public Node run(ManipulateController sharedHandle, List<Node> ln) {
		if (ln == null)
			throw new RuntimeException("Missing parameter.");
		if (ln.size() < 1)
			throw new RuntimeException(String.format("Expected 1 parameter, got: %d", ln.size()));

		// move forward using argument 1
		sharedHandle.back(ln.get(0).getIntegerValue());
		// return argument 1 value
		return ln.get(0);
	}
}