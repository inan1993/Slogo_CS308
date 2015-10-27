package backend.node.control;

import backend.node.types.Constant;
import backend.node.types.ControlStructure;
import responses.Response;
import responses.Success;
import sharedobjects.IWorkspaceVariablesLambda;
import sharedobjects.ManipulateController;
import sharedobjects.Variables;

public class MAKEVAR extends ControlStructure {
	@Override
	public Response run(ManipulateController mc) {
		String variableName = get(0).getName();
		Double result = getAndRun(1, mc).getDoubleValue();
		
		IWorkspaceVariablesLambda l = (Variables v) -> {
			v.setVariable(variableName, new Constant(result));
			return new Constant(0);
		};
		mc.executeOnWorkspaceVariables(l);
		
		return new Success(result);
	}
}