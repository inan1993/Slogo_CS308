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
public class PD extends Command {
	public PD(String name, int children) {
		super(name, children);
	}

	@Override
	public Node run(WorkSpaceController sharedHandle, List<Node> ln) {
		sharedHandle.penDown();

		// return 1
		return new Constant("1").setValue(1);
	}
}