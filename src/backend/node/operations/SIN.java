package backend.node.operations;

import backend.node.OneArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class SIN extends OneArgumentNode{
	public SIN() {
		super();
	}

	@Override
	public Response run(ManipulateController mc) {	
		Double x = getChild(0).getDoubleValue();
		//convert input to radians, sin, conver to degrees
		return new Success(Math.toDegrees(Math.sin(Math.toRadians(x))));
	}
}