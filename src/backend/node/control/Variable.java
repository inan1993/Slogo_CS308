package backend.node.control;

import backend.node.Node;
import backend.node.types.Constant;
import backend.node.types.ZeroArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.IWorkspaceVariablesLambda;
import sharedobjects.ManipulateController;
import sharedobjects.Variables;

public class Variable extends ZeroArgumentNode {
	public Response run(ManipulateController mc) {
		IWorkspaceVariablesLambda l = (Variables v) -> {
			return v.getVariable(this.getName());
		};
		Node n = mc.executeOnWorkspaceVariables(l);
		
		return new Success(n.getDoubleValue());
	}
}