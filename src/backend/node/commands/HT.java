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
public class HT extends ZeroArgumentNode {

	@Override
	public Response run(ManipulateController mc) {
		
		ITurtleLambda l = (Turtle t) -> {
			t.hide();
			
			t.notifyObservers("turtle");
			return 0;
		};
		mc.executeOnAllActiveTurtles(l);

		return new Success(0);
	}
}