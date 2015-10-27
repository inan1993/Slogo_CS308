package backend.node.commands;

import backend.node.types.OneArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ITurtleLambda;
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
		ITurtleLambda l = (Turtle t) -> {
			double[] currPosition = t.getPosition();
			System.out.println("Current Position..." + currPosition[0] + ":" + currPosition[1]);
			
			double heading = t.getHeading();
			
			double xDiff = Math.cos(Math.toRadians(heading))*pixels; //adjacent 
			double yDiff = Math.sin(Math.toRadians(heading))*pixels; //opposite
			
			double xBack = (currPosition[0] - xDiff);
			double yBack = (currPosition[1] + yDiff);
			double[] nextPos = new double[]{xBack, yBack};
			t.setPosition(nextPos);
			t.notifyObservers("turtle");
			return pixels;
		};
		
		sharedHandle.executeOnAllActiveTurtles(l);
		// return argument 1 value
		return new Success(pixels);
	}
}