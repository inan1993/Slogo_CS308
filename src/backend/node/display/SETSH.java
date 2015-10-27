package backend.node.display;

import backend.node.types.OneArgumentNode;
import exceptions.WontImplementException;
import responses.Response;
import responses.Success;
import sharedobjects.DisplayProperties;
import sharedobjects.IDisplayPropertiesLambda;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class SETSH extends OneArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		int index = getAndRun(0, mc).getIntegerValue();
		
		IDisplayPropertiesLambda l = (DisplayProperties d) -> {
			d.setPenShape(index);
		};

		mc.executeDisplayProperties(l);
		return new Success(index);
	}
}