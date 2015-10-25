package backend.node.operations;

import backend.node.TwoArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class TAN extends TwoArgumentNode{
	public TAN() {
		super();
	}

	@Override
	public Response run(ManipulateController mc) {
		Double x = getAndRun(0, mc).getDoubleValue();
		//convert input to radians, sin, convert to degrees
		return new Success(Math.toDegrees(Math.tan(Math.toRadians(x))));
	}
}