
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
public class BK extends Command {
	public BK() {
		super();
		super.setChildrenNum(1);
	}

	@Override
	public Node run(ManipulateController sharedHandle, List<Node> ln) {
		if (ln == null)
			throw new RuntimeException("Missing parameter.");
		if (ln.size() < 1)
			throw new RuntimeException(String.format("Expected 1 parameter, got: %d", ln.size()));
		
		int pixels = ln.get(0).getIntegerValue();
		LambdaInterface l = (Turtle t) -> {
			int[] currPosition = t.getPosition();
			System.out.println("Current Position..." + currPosition[0] + ":" + currPosition[1]);
			
			double heading = t.getHeading();
			
			double xDiff = Math.cos(Math.toRadians(heading))*pixels; //adjacent 
			double yDiff = Math.sin(Math.toRadians(heading))*pixels; //opposite
			
			int xBack = (int) (currPosition[0] - xDiff);
			int yBack = (int) (currPosition[1] - yDiff);
			int[] nextPos = new int[]{xBack, yBack};
			t.setPosition(nextPos);
			TurtleTransferObject dto = new TurtleTransferObject(false, t.getID(), false, t.isPenDown(), t.getPosition(), nextPos);
			t.notifyObservers(dto);
		};
		// move forward using argument 1
		sharedHandle.execute(l);
		// return argument 1 value
		return ln.get(0);
	}
}
