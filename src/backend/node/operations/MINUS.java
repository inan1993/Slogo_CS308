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
public class MINUS extends OneArgumentNode{
	public MINUS() {
		super();
	}

	@Override
	public Response run(ManipulateController mc) {
		Double result = getChild(0).getDoubleValue()*-1;
		return new Success(result);
	}
}
