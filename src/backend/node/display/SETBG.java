package backend.node.display;

import backend.node.types.OneArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.DisplayProperties;
import sharedobjects.IDisplayPropertiesLambda;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class SETBG extends OneArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		// Get index
		int index = getAndRun(0, mc).getIntegerValue();
		IDisplayPropertiesLambda l = (DisplayProperties p) -> {
			p.setBgColor(index);
		};

		mc.executeDisplayProperties(l);
		return new Success(index);
	}
}