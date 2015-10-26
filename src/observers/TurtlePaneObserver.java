//package observers;
//
//import java.util.Observable;
//import java.util.Observer;
//import GUI.turtlepane.TurtleCanvas;
//import GUI.turtlepane.TurtleGroup;
//import datatransferobjects.TurtleTransferObject;
//import sharedobjects.Turtle;
//
//public class TurtlePaneObserver implements Observer{
//
//    private TurtleGroup myTurtleGroup;
//    private TurtleCanvas myTurtleCanvas;
//
//    public TurtlePaneObserver (TurtleGroup turtlePaneGroup, TurtleCanvas turtlePaneCanvas) {
//        this.myTurtleGroup = turtlePaneGroup;
//        this.myTurtleCanvas = turtlePaneCanvas;
//    }
//    
//    @Override
//    public void update (Observable o, Object arg) {
//        Turtle t = (Turtle) o;
//        TurtleTransferObject turtleDTO = (TurtleTransferObject) arg;
//        System.out.println("gothim");
//        if(turtleDTO.isClearScreen()){
//            myTurtleGroup.clear();
//            myTurtleCanvas.clear(); 
//        }
//        else{
//            myTurtleGroup.updateTurtles(turtleDTO);
//            myTurtleCanvas.drawLine(turtleDTO.getOldLoc(), turtleDTO.getNextLoc(), turtleDTO.isPenDown());            
//        }
//    }
//}
//
//
////    public void addSubject(Turtle turtle){
////        this.myTurtles.add(turtle);
////        ImageView turtleImage = createTurtleImage(turtle);
////        myTurtleGroup.getChildren().add(turtleImage);
////    }
////
////    // create and set the location of turtle
////    private ImageView createTurtleImage (Turtle turtle) {
////        Image turtleImage = new Image(getClass().getClassLoader().getResourceAsStream(turtle.getImage()));
////        ImageView turtleImageView = new ImageView(turtleImage);
////        turtleImageView.setX(turtle.getCoordinates()[0]);
////        turtleImageView.setY(turtle.getCoordinates()[1]);
////        return turtleImageView;
////    }
////    
////    // get the location to move to specific location