/**
 * 
 */
package backend.node.commands;

import java.util.List;

import SharedObjects.WorkSpaceController;
import backend.node.Command;
import backend.node.Node;

/**
 * @author loganrooper
 *
 */
public class RT extends Command {
	public RT(String name, int children) {
		super(name, children);
	}

	@Override
	public Node run(WorkSpaceController sharedHandle, List<Node> ln) {
		// If no children but FW, it's wrong!
		if (ln == null)
			throw new RuntimeException("Missing parameter.");
		if (ln.size() < 1)
			throw new RuntimeException(String.format("Expected 1 parameter, got: %d", ln.size()));

		// move forward using argument 1
		sharedHandle.right(ln.get(0).getDoubleValue());

		// return argument 1 value
		return ln.get(0);
	}
}