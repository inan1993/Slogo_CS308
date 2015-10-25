/**
 * 
 */
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
		Double x = getChild(0).getDoubleValue();
		//convert input to radians, sin, conver to degrees
		return new Success(Math.toDegrees(Math.tan(Math.toRadians(x))));
	}
}
