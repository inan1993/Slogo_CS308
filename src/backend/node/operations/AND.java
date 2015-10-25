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
public class AND extends TwoArgumentNode{
	public AND() {
		super();
	}

	@Override
	public Response run(ManipulateController mc) {
		Double a = getChild(0).getDoubleValue();
		Double b = getChild(1).getDoubleValue();
		//convert input to radians, cos, convert to degrees
		return new Success(a > 0 && b > 0 ? 1 : 0);
	}
}