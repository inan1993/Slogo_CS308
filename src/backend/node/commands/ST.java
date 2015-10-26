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
public class ST extends ZeroArgumentNode {

	@Override
	public Response run(ManipulateController mc) {
		LambdaInterface l = (Turtle t) -> {
			TurtleTransferObject dto = new TurtleTransferObject(false, t.getID(), true, t.isPenDown(), t.getPosition(), t.getPosition());
			t.show();
			
			t.notifyObservers(dto);
		};
		mc.execute(l);
		// return 1
		return new Success(1);
	}
}