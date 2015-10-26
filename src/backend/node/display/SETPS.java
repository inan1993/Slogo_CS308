package backend.node.display;

import backend.node.types.OneArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.IPenLambda;
import sharedobjects.ManipulateController;
import sharedobjects.Pen;

/**
 * @author loganrooper
 *
 */
public class SETPS extends OneArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		// Get index
		Double size = getAndRun(0, mc).getDoubleValue();
		IPenLambda l = (Pen p) -> {
			p.setPenThickness(size);
		};

		mc.executePen(l);
		return new Success(size);
	}
}