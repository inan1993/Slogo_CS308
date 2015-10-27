/**
 * 
 */
package backend.node.commands;

import backend.node.types.ZeroArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ITurtleLambda;
import sharedobjects.ManipulateController;
import sharedobjects.Turtle;
/**
 * @author loganrooper
 *
 */
public class ST extends ZeroArgumentNode {

	@Override
	public Response run(ManipulateController mc) {
		ITurtleLambda l = (Turtle t) -> {
			t.show();
			t.notifyObservers("turtle");
			return 0;
		};
		mc.executeOnAllActiveTurtles(l);
		// return 1
		return new Success(1);
	}
}