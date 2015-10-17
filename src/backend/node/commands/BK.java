
package backend.node.commands;

import java.util.List;
import SharedObjects.WorkSpaceController;
import backend.node.Command;
import backend.node.Node;

/**
 * @author loganrooper
 *
 */
public class BK extends Command {
	public BK(String name, int children) {
		super(name, children);
	}

	@Override
	public Node run(WorkSpaceController sharedHandle, List<Node> ln) {
		 //If no children but FW, it's wrong!
		 if (ln == null)
			 throw new RuntimeException("Missing parameter.");
	     //move forward using argument 1
		 sharedHandle.back(ln.get(0).getIntegerValue());
		 //return argument 1 value
		 return ln.get(0);
	}
}