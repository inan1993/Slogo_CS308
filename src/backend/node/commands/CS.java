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
public class CS extends ZeroArgumentNode {

	@Override
	public Response run(ManipulateController sharedHandle) {
		
		ITurtleLambda l = (Turtle t) -> {
			t.setPosition(new double[]{0,0});
			t.notifyObservers("turtle");
			return 0;
		};

		sharedHandle.executeOnAllActiveTurtles(l);
		
		return new Success(0);
		//return distance traveled
	}
}