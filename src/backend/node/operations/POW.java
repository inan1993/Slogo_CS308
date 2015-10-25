package backend.node.operations;

import backend.node.types.TwoArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class POW extends TwoArgumentNode{

	@Override
	public Response run(ManipulateController mc) {
		Double result = Math.pow(getAndRun(0, mc).getDoubleValue(), getAndRun(1, mc).getDoubleValue());
		return new Success(result);
	}
}