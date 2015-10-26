/**
 * 
 */
package backend.node.commands;

import backend.node.types.ZeroArgumentNode;
import datatransferobjects.TurtleTransferObject;
import responses.Response;
import responses.Success;
import sharedobjects.LambdaInterface;
import sharedobjects.ManipulateController;
import sharedobjects.Turtle;

/**
 * @author loganrooper
 *
 */
public class PU extends ZeroArgumentNode {

	@Override
	public Response run(ManipulateController mc) {
		LambdaInterface l = (Turtle t) -> {
			t.penUp();
			TurtleTransferObject dto = new TurtleTransferObject(false, t.getID(), t.isShowing(), t.isPenDown(), t.getPosition(), t.getPosition());
			
			t.notifyObservers(dto);
		};
		mc.execute(l);

		// return 1
		return new Success(1);
	}
}