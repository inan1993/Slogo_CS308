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
public class PD extends ZeroArgumentNode {

	@Override
	public Response run(ManipulateController mc) {
		ITurtleLambda l = (Turtle t) -> {
			t.penDown();	
			t.notifyObservers("turtle");
		};
		mc.executeOnAllActiveTurtles(l);
		// return 1
		return new Success(1);
	}
}