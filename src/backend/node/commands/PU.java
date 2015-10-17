/**
 * 
 */
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
public class PU extends Command {
	public PU(String name, int children) {
		super(name, children);
	}

	@Override
	public Node run(WorkSpaceController sharedHandle, List<Node> ln) {
		sharedHandle.penUp();

		// return 1
		return new Constant("0").setValue(1);
	}
}