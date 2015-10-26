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
public class SETSH extends OneArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		//Get index
		int index = getAndRun(0, mc).getIntegerValue();
		IPenLambda l = (Pen p) -> {
			p.setShape(index);
		};
		
		mc.executePen(l);
		return new Success(index);
	}
}