/**
 * 
 */
package backend.node.commands;

import backend.node.types.ZeroArgumentNode;
import datatransferobjects.TurtleTransferObject;
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
			TurtleTransferObject dto = new TurtleTransferObject(false, t.getID(), false, t.isPenDown(), t.getPosition(), t.getPosition());
			t.hide();
			
			t.notifyObservers(dto);
		};
		mc.execute(l);

		// return 1
		return new Success(1);
	}
}