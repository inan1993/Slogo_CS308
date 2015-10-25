package backend.node.commands;


import backend.node.TwoArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class GOTO extends TwoArgumentNode {
	public GOTO(String name, int children) {
		super();
	}

	@Override
	public Response run(ManipulateController sharedHandle) {
		// get headings
		double prevHeading = sharedHandle.getHeading();

		// get xy
		int x = getChild(0).getIntegerValue();
		int y = getChild(1).getIntegerValue();

		// turn
		sharedHandle.towards(x, y);

		// new heading
		double newHeading = getChild(0).getDoubleValue();

		// return the delta
		return new Success(prevHeading - newHeading);
	}
}