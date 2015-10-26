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

        
        public void execute(ITurtleLambda lambda){
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
        
        public void tellTurtles(int[] ids){
        	Map<Integer, Turtle> allTurtles = currWorkspace.getAllTurtles();
        	currWorkspace.setActiveTurtles(Collections.<Turtle> emptyList());
        	List<Turtle> nextActiveList = new LinkedList<Turtle>();
        	for(int id = 0; id < ids.length; id++){
        		if(allTurtles.containsKey(id)){
        			Turtle temp = allTurtles.get(id);
        			temp.activate();
        			nextActiveList.add(temp);
        		}else {
        			Turtle temp = currWorkspace.addNewTurtle(id);
        			nextActiveList.add(temp);
        		}
        	}
        	currWorkspace.setActiveTurtles(nextActiveList);
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

		public void incrementVariable(String variableName) {
			currWorkspace.addVariable(variableName, new Constant(currWorkspace.getVariable(variableName).getIntegerValue()+1));
		}
		
		public void incrementVariableByValue(String variableName, int value) {
			currWorkspace.addVariable(variableName, new Constant(currWorkspace.getVariable(variableName).getIntegerValue()+value));
		}
		
		public void decrementVariable(String variableName) {
			currWorkspace.addVariable(variableName, new Constant(currWorkspace.getVariable(variableName).getIntegerValue()-1));
		}


		@Override
		public Response setCommand(String stringName, Node n) {
            currWorkspace.addCommand(stringName, n);
			return null;
		}

		public void executePen(IPenLambda l) {}

}