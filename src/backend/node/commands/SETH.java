package backend.node.commands;

import java.util.List;

import backend.node.Command;
import backend.node.Constant;
import backend.node.Node;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class SETH extends Command {
	public SETH(String name, int children) {
		super(name, children);
	}

	@Override
	public Node run(ManipulateController sharedHandle, List<Node> ln) {
		 if (ln == null)
			 throw new RuntimeException("Missing parameter.");
		 if (ln.size() < 1)
			 throw new RuntimeException(String.format("Expected 1 parameter, got: %d", ln.size()));
		 
		 //get headings
		 double prevHeading = sharedHandle.getHeading();
		 double newHeading = ln.get(0).getDoubleValue();
		 
	     //turn
		 sharedHandle.setHeading(newHeading);
		 
		 //return the delta
		 return new Constant("Heading").setValue(prevHeading-newHeading);
	}
}