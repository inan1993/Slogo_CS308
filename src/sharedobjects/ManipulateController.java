package sharedobjects;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import backend.node.Node;
import responses.Response;

public class ManipulateController implements IWorkSpaceController {
	private Workspace currWorkspace;
	private List<Workspace> workspaceList = new LinkedList<Workspace>();

	public ManipulateController(Workspace w) {
		currWorkspace = w;
		workspaceList.add(currWorkspace);
	}

	public void setTempTurtles(int[] ids) {
		currWorkspace.getTurtleContainer().setTempTurtles(ids);
	}

	public void clearTempTurtles() {
		currWorkspace.setTempTurtles(Collections.<Turtle> emptyList());
	}

	public int tellTurtles(int[] ids) {
		return currWorkspace.getTurtleContainer().tellTurtles(ids);
	}

	public double executeDisplayProperties(IDisplayPropertiesLambda l) {
		return l.run(currWorkspace.getDisplayProp());
	}
	
	public Node executeOnWorkspaceFunctions(IWorkspaceFunctionsLambda l) {
		return l.run(currWorkspace.getFuncs());
	}
	
	public Node executeOnWorkspaceVariables(IWorkspaceVariablesLambda l) {
		return l.run(currWorkspace.getVars());
	}

	public double executeOnTurtleContainer(ITurtleLambda lambda) {
		return currWorkspace.executeOnAllActiveTurtles(lambda);	
	}
	
	public void setReponse(Response s) {
		currWorkspace.setCurrentResponse(s);
	}

	@Override
	public double executeOnAllActiveTurtles(ITurtleLambda lambda) {
		return currWorkspace.executeOnAllActiveTurtles(lambda);
	}
	
	public double executeOnCurrentTurtle(ITurtleLambda lambda){
		return currWorkspace.executeOnCurrentTurtle(lambda);
	}
}