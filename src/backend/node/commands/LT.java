/**
 * 
 */
package backend.node.commands;

import java.util.List;

import backend.node.Command;
import backend.node.Node;
import sharedobjects.WorkSpaceController;

/**
 * @author loganrooper
 *
 */
public class LT extends Command {
	public LT(String name, int children) {
		super(name, children);
	}

	@Override
	public Node run(WorkSpaceController sharedHandle, List<Node> ln) {
		if (ln == null)
			throw new RuntimeException("Missing parameter.");
		if (ln.size() < 1)
			throw new RuntimeException(String.format("Expected 1 parameter, got: %d", ln.size()));

		sharedHandle.left(ln.get(0).getDoubleValue());

		// return argument 1 value
		return ln.get(0);
	}
}