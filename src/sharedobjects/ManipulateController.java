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
		Map<Integer, Turtle> allTurtles = currWorkspace.getAllTurtles();
		List<Turtle> tempTurtles = new LinkedList<Turtle>();
		for (int i = 0; i < ids.length; i++) {
			if (allTurtles.containsKey(i)) {
				tempTurtles.add(allTurtles.get(i));
			}
		}
		currWorkspace.setTempTurtles(tempTurtles);
	}

	public void clearTempTurtles() {
		currWorkspace.setTempTurtles(Collections.<Turtle> emptyList());
	}

	//
	public int tellTurtles(int[] ids) {
		Map<Integer, Turtle> allTurtles = currWorkspace.getAllTurtles();
		currWorkspace.setActiveTurtles(Collections.<Turtle> emptyList());
		List<Turtle> nextActiveList = new LinkedList<Turtle>();
		for (int id = 0; id < ids.length; id++) {
			if (allTurtles.containsKey(ids[id])) {
				Turtle temp = allTurtles.get(ids[id]);
				temp.activate();
				nextActiveList.add(temp);
			} else {
				Turtle temp = currWorkspace.addNewTurtle(ids[id]);
				nextActiveList.add(temp);
			}
		}
		currWorkspace.setActiveTurtles(nextActiveList);
		return ids[ids.length-1];
	}

	// Execute on observables
	public double executeWorkspace(IWorkspaceLambda l) {
		return l.run(currWorkspace);
	}

	public double executeDisplayProperties(IDisplayPropertiesLambda l) {
		return l.run(currWorkspace.displayProp);
	}
	
	public Node executeOnWorkspaceFunctions(IWorkspaceFunctionsLambda l) {
		return l.run(currWorkspace.funcs);
	}
	
	public Node executeOnWorkspaceVariables(IWorkspaceVariablesLambda l) {
		return l.run(currWorkspace.vars);
	}

	public double executeOnAllActiveTurtles(ITurtleLambda lambda) {
		List<Turtle> turtles = (currWorkspace.getTempTurtles().size() > 0) ? currWorkspace.getTempTurtles()
				: currWorkspace.getActiveTurtles();
		
		double response = 0;
		for (Turtle turtle : turtles) {
			response = lambda.run(turtle);
		}
		return response;
	}
	
	public void setReponse(Response s) {
		currWorkspace.setCurrentResponse(s);
	}
}