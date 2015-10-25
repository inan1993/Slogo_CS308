package backend.node.operations;

import backend.node.OneArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class LESSP extends OneArgumentNode{
	public LESSP() {
		super();
	}

	@Override
	public Response run(ManipulateController mc) {	
		Double a = getChild(0).getDoubleValue();
		Double b = getChild(1).getDoubleValue();
		//convert input to radians, cos, conver to degrees
		return new Success(a < b ? 1 : 0);
	}
}