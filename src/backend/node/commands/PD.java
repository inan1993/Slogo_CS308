/**
 * 
 */
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
public class PD extends Command {
	public PD(String name, int children) {
		super();
	}

	@Override
	public Node run(ManipulateController sharedHandle, List<Node> ln) {
		sharedHandle.penDown();

		// return 1
		return new Constant().setValue(1);
	}
}