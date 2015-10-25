package backend.node.commands;

import backend.node.types.OneArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class SETH extends OneArgumentNode {

	@Override
	public Response run(ManipulateController sharedHandle) {
		 //get headings
		 double prevHeading = sharedHandle.getHeading();
		 double newHeading = getAndRun(0, sharedHandle).getDoubleValue();
		 
	     //turn
		 sharedHandle.setHeading(newHeading);
		 
		 //return the delta
		 return new Success(prevHeading-newHeading);
	}
}