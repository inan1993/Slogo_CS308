package backend.node.display;

import backend.node.types.ZeroArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.DisplayProperties;
import sharedobjects.IDisplayPropertiesLambda;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class SH extends ZeroArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		IDisplayPropertiesLambda l = (DisplayProperties p) -> {
			return p.getShape();
		};

		double result = mc.executeDisplayProperties(l);
		return new Success(result);
	}
}