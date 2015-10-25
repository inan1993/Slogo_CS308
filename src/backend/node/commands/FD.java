package backend.node.commands;

import java.util.List;

import backend.factory.CommandFactory;
import backend.parser.SyntaxType;
import datatransferobjects.TurtleTransferObject;
import responses.Response;
import responses.Success;
import sharedobjects.LambdaInterface;
import sharedobjects.ManipulateController;
import sharedobjects.Turtle;
import backend.node.Command;
import backend.node.Node;
import backend.node.OneArgumentNode;

public class FD extends OneArgumentNode {
	public FD() {
		super();
	}

	@Override
	public Response run(ManipulateController sharedHandle) {
		int pixels = getChild(0).getIntegerValue();
		LambdaInterface l = (Turtle t) -> {
			int[] currPosition = t.getPosition();
			System.out.println("Current Position..." + currPosition[0] + ":" + currPosition[1]);
			
			double heading = t.getHeading();
			
			double xDiff = Math.cos(Math.toRadians(heading))*pixels; //adjacent 
			double yDiff = Math.sin(Math.toRadians(heading))*pixels; //opposite
			
			int xBack = (int) (currPosition[0] + xDiff);
			int yBack = (int) (currPosition[1] + yDiff);
			int[] nextPos = new int[]{xBack, yBack};
			t.setPosition(nextPos);
			TurtleTransferObject dto = new TurtleTransferObject(false, t.getID(), false, t.isPenDown(), t.getPosition(), nextPos);
			t.notifyObservers(dto);
		};
		System.out.println("Got to Command FD");
		sharedHandle.execute(l);
		// return argument 1 value
		return new Success(this.getChild(0).getDoubleValue());
		
	}
}
