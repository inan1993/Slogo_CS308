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
public class HT extends Command {
	public HT(String name, int children) {
		super(name, children);
	}

	@Override
	public Node run(ManipulateController sharedHandle, List<Node> ln) {
		sharedHandle.showTurtle();

		// return 1
		return new Constant("0").setValue(1);
	}
}