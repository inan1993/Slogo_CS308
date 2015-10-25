/**
 * 
 */
package backend.node.commands;

import java.util.List;

import backend.node.Command;
import backend.node.Node;
import datatransferobjects.TurtleTransferObject;
import sharedobjects.LambdaInterface;
import sharedobjects.ManipulateController;
import sharedobjects.Turtle;

/**
 * @author loganrooper
 *
 */
public class LT extends Command {
	public LT() {
		super();
		super.setChildrenNum(1);
	}

	@Override
	public Node run(ManipulateController sharedHandle, List<Node> ln) {
		if (ln == null)
			throw new RuntimeException("Missing parameter.");
		if (ln.size() < 1)
			throw new RuntimeException(String.format("Expected 1 parameter, got: %d", ln.size()));

		int degrees = ln.get(0).getIntegerValue();
		LambdaInterface l = (Turtle t) -> {
			double currHeading = t.getHeading();
			currHeading -= degrees;
			if(currHeading < 0){
	               currHeading += 360;
			}
			t.setHeading(currHeading);
		};
		sharedHandle.execute(l);
		
		// return argument 1 value
		return ln.get(0);
	}
}