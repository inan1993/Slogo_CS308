package backend.node.display;

import backend.node.types.FourArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.IWorkspaceLambda;
import sharedobjects.ManipulateController;
import sharedobjects.Workspace;

/**
 * @author loganrooper
 *
 */
public class SETPALETTE extends FourArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		// Get index
		int index = getAndRun(0, mc).getIntegerValue();
		int r = getAndRun(1, mc).getIntegerValue();
		int g = getAndRun(2, mc).getIntegerValue();
		int b = getAndRun(3, mc).getIntegerValue();
		
		IWorkspaceLambda l = (Workspace w) -> {
			w.addColorToPalette(index, r, g, b);
		};

		mc.executeWorkspace(l);
		return new Success(index);
	}
}