package backend.node.commands;

import backend.node.OneArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class SETH extends OneArgumentNode {
	public SETH(String name, int children) {
		super();
	}

	@Override
	public Response run(ManipulateController sharedHandle) {
		 //get headings
		 double prevHeading = sharedHandle.getHeading();
		 double newHeading = getChild(0).getDoubleValue();
		 
	     //turn
		 sharedHandle.setHeading(newHeading);
		 
		 //return the delta
		 return new Success(prevHeading-newHeading);
	}
}