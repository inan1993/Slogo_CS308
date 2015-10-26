package backend.node.display;

import backend.node.types.OneArgumentNode;
import responses.Response;
import sharedobjects.IPenLambda;
import sharedobjects.ManipulateController;
import sharedobjects.Pen;

/**
 * @author loganrooper
 *
 */
public class SETSH extends OneArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		// Call mc.getPen().setBG()
		IPenLambda l = (Pen p) -> {
			p.setShape();
		};
		
		//mc.executePen(l);

		return null;
	}
}