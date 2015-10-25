/**
 * 
 */
package backend.node.commands;

import java.util.List;

import backend.node.Command;
import backend.node.Node;
import sharedobjects.LambdaInterface;
import sharedobjects.ManipulateController;
import sharedobjects.Turtle;

/**
 * @author loganrooper
 *
 */
public class RT extends Command {
	public RT() {
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
			System.out.println(currHeading);
			currHeading -= degrees;
			if(currHeading < 0){
	               currHeading += 360;
			}
			t.setHeading(currHeading);
			System.out.println(currHeading);
		};
		sharedHandle.execute(l);
		
		// return argument 1 value
		return ln.get(0);
	}
}