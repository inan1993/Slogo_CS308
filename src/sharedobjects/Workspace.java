package sharedobjects;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import javafx.scene.paint.Color;
import responses.Response;
import responses.Success;

public class Workspace {
	Map<Integer, Turtle> allTurtles;
	List<Turtle> activeTurtles;
	List<Turtle> tempTurtles;
	List<Color> colorPalette;

	DisplayProperties displayProp;
	Variables vars;
	Functions funcs;
	private Response response;

	public Workspace() {
		allTurtles = new HashMap<Integer, Turtle>();
		allTurtles.put(1, new Turtle(1));
		activeTurtles = new LinkedList<Turtle>();
		activeTurtles.add(allTurtles.get(1));
		tempTurtles = new LinkedList<Turtle>();
		displayProp = new DisplayProperties();
		vars = new Variables();
		funcs = new Functions();
		response = new Success("");
	}

	public Turtle addNewTurtle(int id) {
		Turtle turt = new Turtle(id);
		allTurtles.put(id, turt);
		return turt;
	}

	public Map<Integer, Turtle> getAllTurtles() {
		return allTurtles;
	}

	public List<Turtle> getActiveTurtles() {
		return activeTurtles;
	}

	public void setActiveTurtles(List<Turtle> activeTurtles) {
		this.activeTurtles = activeTurtles;
	}

	public void setTempTurtles(List<Turtle> tempTurtles) {
		this.tempTurtles = tempTurtles;
	}

	public List<Turtle> getTempTurtles() {
		return tempTurtles;
	}


	public List<Observable> getObservables() {
		List<Observable> observables = new LinkedList<Observable>();
		for (Turtle t : activeTurtles) {
			System.out.println("here2");
			observables.add((Observable) t);
		}

		observables.add(displayProp);
		observables.add(response);
		observables.add(funcs);
		observables.add(vars);
		return observables;
	}

	public void startWorkspace() {
		Turtle firstTurtle = activeTurtles.get(0);
		firstTurtle.notifyObservers("turtle");
		displayProp.notifyObservers();
		System.out.println("here1");
	}

	/**
	 * @param s
	 */
	public void setCurrentResponse(Response s) {
		response.updateValue(s.toString());
		response.notifyObservers("Response");
	}

}