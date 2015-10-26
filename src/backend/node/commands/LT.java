package backend.node.commands;

import backend.node.types.OneArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ITurtleLambda;
import sharedobjects.ManipulateController;
import sharedobjects.Turtle;

public class LT extends OneArgumentNode {
	
	@Override
	public Response run(ManipulateController sharedHandle) {
		int degrees = getAndRun(0, sharedHandle).getIntegerValue();
		ITurtleLambda l = (Turtle t) -> {
			double currHeading = t.getHeading();
			System.out.println(currHeading);
			currHeading += degrees;
			while(currHeading > 360){
	               currHeading -= 360;
			}
			t.setHeading(currHeading);
			System.out.println(currHeading);
		};
		sharedHandle.execute(l);
		
		// return argument 1 value
		return new Success(getAndRun(0, sharedHandle).toString());
	}
}