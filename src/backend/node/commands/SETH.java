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
public class SETH extends Command {
	public SETH(String name, int children) {
		super(name, children);
	}

	@Override
	public Node run(WorkSpaceController sharedHandle, List<Node> ln) {
		 //If no children but FW, it's wrong!
		 if (ln == null)
			 throw new RuntimeException("Missing parameter.");
		 //get current heading
		 double prevHeading = sharedHandle.getHeading();
		 double newHeading = ln.get(0).getDoubleValue();
	     //turn using argument 1
		 sharedHandle.setHeading(newHeading);
		 
		 
		 //return argument 1 value
		 return new Constant().setValue(prevHeading-newHeading);
	}
}