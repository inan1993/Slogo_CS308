package backend.node.operations;

import backend.node.TwoArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class SUM extends TwoArgumentNode{
	public SUM() {
		super();
	}

	@Override
	public Response run(ManipulateController mc) {
		Double result = getAndRun(0, mc).getDoubleValue()+getAndRun(1, mc).getDoubleValue();
		return new Success(result);
	}
}