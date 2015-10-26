package backend.node.control;

import backend.node.types.Constant;
import backend.node.types.ControlStructure;
import responses.Error;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

public class FOR extends ControlStructure {
	@Override
	public Response run(ManipulateController mc) {
		String variableName = get(0).getName();

		int startInt = (int) getAndRun(1, mc).getDoubleValue();
		int endInt = (int) getAndRun(2, mc).getDoubleValue();
		int increment = (int) getAndRun(3, mc).getDoubleValue();
		mc.addVariable(variableName, new Constant(startInt));

		// Run - return 0 by default
		Response s = new Success(0);
		for (int i = startInt; i < endInt; i += increment) {
			s = getAndRun(4, mc);
			// Increment
			mc.incrementVariableByValue(variableName, increment);
		}

		// Return
		return s;
	}
}
