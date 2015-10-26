package backend.node.commands;

import backend.node.types.OneArgumentNode;
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
public class SETH extends OneArgumentNode {

	@Override
	public Response run(ManipulateController mc) {
		 //get headings
		 double newHeading = getAndRun(0, mc).getDoubleValue();
		 ITurtleLambda l = (Turtle t) -> {
			t.setHeading(newHeading);
			TurtleTransferObject dto = new TurtleTransferObject(false, t.getID(), t.isShowing(), t.isPenDown(), t.getPosition(), t.getPosition());
				
			t.notifyObservers(dto);
		};
		mc.execute(l);
	   
		 //return the delta
		 return new Success(1);
	}
}