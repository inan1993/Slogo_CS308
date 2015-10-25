package backend.node.operations;

import backend.node.types.TwoArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class COS extends TwoArgumentNode{

	@Override
	public Response run(ManipulateController mc) {
		Double x = getAndRun(0, mc).getDoubleValue();
		//convert input to radians, cos, conver to degrees
		return new Success(Math.toDegrees(Math.cos(Math.toRadians(x))));
	}
}