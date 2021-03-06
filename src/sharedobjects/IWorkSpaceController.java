package sharedobjects;

import backend.node.Node;
import responses.Response;

public interface IWorkSpaceController {	
	//Turtles
	void setTempTurtles(int[] ids);
	void clearTempTurtles();
	int tellTurtles(int[] ids);
	
	//Observables
	double executeDisplayProperties(IDisplayPropertiesLambda l);
	Node executeOnWorkspaceFunctions(IWorkspaceFunctionsLambda l);
	Node executeOnWorkspaceVariables(IWorkspaceVariablesLambda l);
	double executeOnAllActiveTurtles(ITurtleLambda lambda);
	
	//Response
	void setReponse(Response s);
}
