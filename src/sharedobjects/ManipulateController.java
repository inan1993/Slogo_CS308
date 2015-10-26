package sharedobjects;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import backend.node.Node;
import backend.node.types.Constant;
import responses.Response;

public class ManipulateController implements IWorkSpaceController{

        private Workspace currWorkspace;
        private List<Workspace> workspaceList = new LinkedList<Workspace>();
        
        public ManipulateController(Workspace w) {
                currWorkspace = w;
                workspaceList.add(currWorkspace);
        }

        
        public void execute(LambdaInterface lambda){
        	List<Turtle> turtles = (currWorkspace.getTempTurtles().size() > 0) ? 
        			currWorkspace.getTempTurtles() : currWorkspace.getActiveTurtles();
       
        	for(Turtle turtle : turtles){
        		lambda.run(turtle);
        	}
        }
        
        public void setTempTurtles(int[] ids){
        	Map<Integer, Turtle> allTurtles = currWorkspace.getAllTurtles();
        	List<Turtle> tempTurtles = new LinkedList<Turtle>();
        	for(int i = 0; i < ids.length; i++){
        		if(allTurtles.containsKey(i)){
        			tempTurtles.add(allTurtles.get(i));
        		}
        	}
        	currWorkspace.setTempTurtles(tempTurtles);
        }
        
        public void clearTempTurtles(){
        	currWorkspace.setTempTurtles(Collections.<Turtle> emptyList());
        }
        
        
        public double getHeading(){
        	return 0;
        }
        
        public void addVariable(String v, Node n){
    		currWorkspace.addVariable(v, n);
    	}

		@Override
		public Response foward(int pixels) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Response back(int pixels) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Response left(double degrees) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Response right(double degrees) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Response setHeading(double degrees) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Response towards(int x, int y) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Response setXY(int x, int y) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Response penDown() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Response penUp() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Response showTurtle() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Response hideTurtle() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Response home() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Response clearScreen() {
			// TODO Auto-generated method stub
			return null;
		}

        
//        @Override
//        public Response foward(int pixels) {
//                int[] currPosition = currWorkspace.getPosition();
//                double heading = currWorkspace.getHeading();
//                
//                double xDiff = Math.cos(Math.toRadians(heading))*pixels; //adjacent 
//                double yDiff = Math.sin(Math.toRadians(heading))*pixels; //opposite
//                
//                int xBack = (int) (currPosition[0] + xDiff);
//                int yBack = (int) (currPosition[1] + yDiff);
//
//                currWorkspace.setPosition(new int[]{xBack, yBack});
//                return null;
//        }
//
//        @Override
//        public Response back(int pixels) {
//                int[] currPosition = currWorkspace.getPosition();
//                double heading = currWorkspace.getHeading();
//                
//                double xDiff = Math.cos(Math.toRadians(heading))*pixels; //adjacent 
//                double yDiff = Math.sin(Math.toRadians(heading))*pixels; //opposite
//                
//                int xBack = (int) (currPosition[0] - xDiff);
//                int yBack = (int) (currPosition[1] - yDiff);
//
//                currWorkspace.setPosition(new int[]{xBack, yBack});
//                
//                return null;
//        }
//
//        @Override
//        public Response left(double degrees) {
//                double currHeading = currWorkspace.getHeading();
//                currHeading -= degrees;
//                if(currHeading < 0){
//                        currHeading += 360;
//                }
//                currWorkspace.setHeading(currHeading);
//                
//                return null;
//        }
//
//        @Override
//        public Response right(double degrees) {
//                double currHeading = currWorkspace.getHeading();
//                currHeading += degrees;
//                if(currHeading > 360){
//                        currHeading -= 360;
//                }
//                currWorkspace.setHeading(currHeading);
//                
//                return null;
//        }
//
//        @Override
//        public Response setHeading(double degrees) {
//                currWorkspace.setHeading(degrees);
//                
//                return null;
//        }
//
//        @Override
//        public Response towards(int targetX, int targetY) {
//                int[] currPos = currWorkspace.getPosition();
//        
//                double theta = Math.atan2(targetY - currPos[1], targetX - currPos[0]);
//                double angle = Math.toDegrees(theta);
//                angle = 360 - angle;
//                
//                if(angle >= 360){
//                        angle = angle - 360;
//                }
//                currWorkspace.setHeading(angle);
//                return null;
//        }
//
//        @Override
//        public Response setXY(int x, int y) {
//                currWorkspace.setPosition(new int[]{x,y});
//                return null;
//        }
//
//        @Override
//        public Response penDown() {
//                currWorkspace.penDown();
//                return null;
//        }
//
//        @Override
//        public Response penUp() {
//                currWorkspace.penUp();
//                return null;
//        }
//
//        @Override
//        public Response showTurtle() {
//                currWorkspace.showTurtle();
//                return null;
//        }
//
//        @Override
//        public Response hideTurtle() {
//                currWorkspace.hideTurtle();
//                return null;
//        }
//
//        @Override
//        public Response home() {
//                currWorkspace.setPosition(new int[]{0,0});
//                return null;
//        }
//
//        @Override
//        public Response clearScreen() {
//                home();
//                return null;
//        }
//
        @Override
        public Response setCommand(String userInput, String stringName, Node n) {
                currWorkspace.addCommand(userInput, stringName, n);
                return null;
        }

        @Override
        public Node getCommand(String commandName) {
                return currWorkspace.getCommand(commandName);
        }

        @Override
        public Response setVariable(String variableName, Node var) {
                currWorkspace.addVariable(variableName, var);
                return null;
        }

        @Override
        public Node getVariable(String variableName) {
                return currWorkspace.getVariable(variableName);
        }
//
//        public double getHeading() {
//                return currWorkspace.getHeading();
//        }

		public void incrementVariable(String variableName) {
			currWorkspace.addVariable(variableName, new Constant(currWorkspace.getVariable(variableName).getIntegerValue()+1));
		}
		
		public void decrementVariable(String variableName) {
			currWorkspace.addVariable(variableName, new Constant(currWorkspace.getVariable(variableName).getIntegerValue()-1));
		}

}