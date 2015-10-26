package datatransferobjects;

public class TurtleTransferObject {
    private boolean clearScreen;
    private double ID;
    private boolean visible;
    private boolean penDown;
    private double[] oldLoc;
    private double[] nextLoc;

    public TurtleTransferObject(boolean cs, double i, boolean v, boolean b, double[] ds , double[] nextPos) {
        clearScreen = cs;
        ID = i;
        visible = v;
        penDown = b;
        oldLoc = ds;
        nextLoc = nextPos;
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
    public double[] getOldLoc() {
        return oldLoc;
    }

    public double[] getNextLoc() {
        return nextLoc;
    }

}