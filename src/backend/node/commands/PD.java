/**
 * 
 */
package backend.node.commands;

import backend.node.types.ZeroArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.DisplayProperties;
import sharedobjects.IDisplayPropertiesLambda;
import sharedobjects.ManipulateController;
import sharedobjects.Turtle;

/**
 * @author loganrooper
 *
 */
public class PD extends ZeroArgumentNode {

	@Override
	public Response run(ManipulateController mc) {
		mc.executeDisplayProperties((DisplayProperties t) -> {
			t.setPenDown(true);
			t.notifyObservers("pen");
			return 0;
		});
		// return 1
		return new Success(1);
	}
}