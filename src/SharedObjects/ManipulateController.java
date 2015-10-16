package sharedobjects;

import java.util.LinkedList;
import java.util.List;

import responses.Response;

public class ManipulateController implements IWorkSpaceController{

	private Workspace currWorkspace;
	private List<Workspace> workspaceList = new LinkedList<Workspace>();
	
	public ManipulateController() {
		currWorkspace = new Workspace();
		workspaceList.add(currWorkspace);
	}

	@Override
	public Response foward(int pixels) {
		int[] currPosition = currWorkspace.getPosition();
		double heading = currWorkspace.getHeading();
		
		double xDiff = Math.cos(heading)/pixels; //adjacent 
		double yDiff = Math.sin(heading)/pixels; //opposite
		
		int xBack = (int) (currPosition[0] + xDiff);
		int yBack = (int) (currPosition[1] + yDiff);

		currWorkspace.setPosition(new int[]{xBack, yBack});
		return null;
	}

	@Override
	public Response back(int pixels) {
		int[] currPosition = currWorkspace.getPosition();
		double heading = currWorkspace.getHeading();
		
		double xDiff = Math.cos(heading)/pixels; //adjacent 
		double yDiff = Math.sin(heading)/pixels; //opposite
		
		int xBack = (int) (currPosition[0] - xDiff);
		int yBack = (int) (currPosition[1] - yDiff);

		currWorkspace.setPosition(new int[]{xBack, yBack});
		
		return null;
	}

	@Override
	public Response left(double degrees) {
		double currHeading = currWorkspace.getHeading();
		currHeading -= degrees;
		if(currHeading < 0){
			currHeading += 360;
		}
		currWorkspace.setHeading(currHeading);
		
		return null;
	}

	@Override
	public Response right(double degrees) {
		double currHeading = currWorkspace.getHeading();
		currHeading += degrees;
		if(currHeading > 360){
			currHeading -= 360;
		}
		currWorkspace.setHeading(currHeading);
		
		return null;
	}

	@Override
	public Response setHeading(double degrees) {
		currWorkspace.setHeading(degrees);
		
		return null;
	}

	@Override
	public Response towards(int targetX, int targetY) {
		int[] currPos = currWorkspace.getPosition();
	
		double theta = Math.atan2(targetY - currPos[1], targetX - currPos[0]);
		double angle = Math.toDegrees(theta);
		angle = 360 - angle;
		
		if(angle >= 360){
		 	angle = angle - 360;
		}
		currWorkspace.setHeading(angle);
		return null;
	}

	@Override
	public Response setXY(int x, int y) {
		currWorkspace.setPosition(new int[]{x,y});
		return null;
	}

	@Override
	public Response penDown() {
		currWorkspace.penDown();
		return null;
	}

	@Override
	public Response penUp() {
		currWorkspace.penUp();
		return null;
	}

	@Override
	public Response showTurtle() {
		currWorkspace.showTurtle();
		return null;
	}

	@Override
	public Response hideTurtle() {
		currWorkspace.hideTurtle();
		return null;
	}

	@Override
	public Response home() {
		currWorkspace.setPosition(new int[]{0,0});
		return null;
	}

	@Override
	public Response clearScreen() {
		// TODO: NEED TO MAKE DECISION ABOUT PENS
		home();
		return null;
	}

}
