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
public class CS extends ZeroArgumentNode {

	@Override
	public Response run(ManipulateController sharedHandle) {
		
		LambdaInterface l = (Turtle t) -> {
			TurtleTransferObject dto = new TurtleTransferObject(false, t.getID(), false, t.isPenDown(), t.getPosition(), new int[]{0,0});
			t.setPosition(new int[]{0,0});
			t.notifyObservers(dto);
		};

		sharedHandle.execute(l);
		
		return new Success(0);
		//return distance traveled
	}
}