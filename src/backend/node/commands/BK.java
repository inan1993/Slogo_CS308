
package backend.node.commands;

import backend.node.OneArgumentNode;
import datatransferobjects.TurtleTransferObject;
import responses.Response;
import responses.Success;
import sharedobjects.LambdaInterface;
import sharedobjects.ManipulateController;
import sharedobjects.Turtle;


/**
 * @author loganrooper
 *
 */
public class BK extends OneArgumentNode {

	@Override
	public Response run(ManipulateController sharedHandle) {
		int pixels = getAndRun(0, sharedHandle).getIntegerValue();
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
		
		// return argument 1 value
		return new Success(getAndRun(0, sharedHandle).getDoubleValue());
	}
}
