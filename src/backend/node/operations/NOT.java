/**
 * 
 */
package backend.node.operations;

import backend.node.OneArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class NOT extends OneArgumentNode{
	public NOT() {
		super();
	}

	@Override
	public Response run(ManipulateController mc) {	
		Double a = getChild(0).getDoubleValue();
		//convert input to radians, cos, conver to degrees
		return new Success(a == 0 ? 1 : 0);
	}
}