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

	@Override
	public Response run(ManipulateController sharedHandle) {
		// get headings
		double prevHeading = sharedHandle.getHeading();

		// get xy
		int x = getAndRun(0, sharedHandle).getIntegerValue();
		int y = getAndRun(1, sharedHandle).getIntegerValue();

		// turn
		sharedHandle.towards(x, y);

		// new heading
		double newHeading = getAndRun(0, sharedHandle).getDoubleValue();

		// return the delta
		return new Success(prevHeading - newHeading);
	}
}