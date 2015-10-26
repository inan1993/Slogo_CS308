package backend.node.control;

import backend.node.Node;
import backend.node.types.Constant;
import backend.node.types.ControlStructure;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

public class DOTIMES extends ControlStructure {
	@Override
	public Response run(ManipulateController mc) {
		int count = (int) getAndRun(1, mc).getDoubleValue();
		String variableName = get(0).getName();
		mc.addVariable(variableName, new Constant(0));
		
		// Run
		Response s = new Success(0);
		for (int i = 0; i < count; i++) {
			s = getAndRun(2, mc);
			//Increment
			mc.incrementVariable(variableName);
		}

		// Return
		return s;
	}
}