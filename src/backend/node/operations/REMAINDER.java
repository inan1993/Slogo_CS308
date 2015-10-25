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
public class REMAINDER extends TwoArgumentNode{
	public REMAINDER() {
		super();
	}

	@Override
	public Response run(ManipulateController mc) {	
		Double result = getChild(0).getDoubleValue()%getChild(1).getDoubleValue();
		return new Success(result);
	}
}