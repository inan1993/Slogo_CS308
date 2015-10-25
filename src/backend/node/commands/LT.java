package backend.node.commands;

import backend.node.OneArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.LambdaInterface;
import sharedobjects.ManipulateController;
import sharedobjects.Turtle;

/**
 * @author loganrooper
 *
 */
public class LT extends OneArgumentNode {
	
	@Override
	public Response run(ManipulateController sharedHandle) {
		int degrees = getAndRun(0, sharedHandle).getIntegerValue();
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
		return new Success(getAndRun(0, sharedHandle).toString());
	}
}