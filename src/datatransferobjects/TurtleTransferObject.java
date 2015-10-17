package datatransferobjects;

public class TurtleTransferObject {
	private boolean clearScreen;
	private double ID;
	private boolean visible;
	private boolean penDown;
	private int[] oldLoc;
	private int[] nextLoc;
	
	public TurtleTransferObject(boolean cs, double i, boolean v, boolean b, int[] o , int[] n) {
		clearScreen = cs;
		ID = i;
		visible = v;
		penDown = b;
		oldLoc = o;
		nextLoc = n;
	}
	
	public boolean isClearScreen(){
		return clearScreen;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public double getID(){
		return ID;
	}
	
	public boolean isPenDown(){
		return penDown;
	}

	public int[] getOldLoc() {
		return oldLoc;
	}

	public int[] getNextLoc() {
		return nextLoc;
	}
	
}
