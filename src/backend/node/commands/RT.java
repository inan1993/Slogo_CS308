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
public class RT extends OneArgumentNode {
	public RT() {
		super();
	}

	@Override
	public Response run(ManipulateController sharedHandle) {
		int degrees = getChild(0).getIntegerValue();
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
		return new Success(getChild(0).toString());
	}
}