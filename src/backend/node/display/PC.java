package backend.node.display;

import backend.node.types.ZeroArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.DisplayProperties;
import sharedobjects.IDisplayPropertiesGetLambda;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class PC extends ZeroArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		IDisplayPropertiesGetLambda l = (DisplayProperties p) -> {
			return p.getPenColor();
		};

		double result = mc.getDataFromDisplay(l);
		return new Success(result);
	}
}