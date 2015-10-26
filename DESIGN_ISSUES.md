###Design Issues
- Business Logic in the front End??
  + The front end is checking to see if the ***pen is up or down*** before drawing the line.
  + The front end is checking to see if the ***clearScreen*** is true before updating the view.
    - Should the logic be pushed into the FrontEndObserver or should it all happen in the backend. 
    - Should the frontEnd just expose an API (.clearScree()) that the backend can use when it wants. 
    - Or should we implement an Observerable pattern for clearScreen. If so how?
- The front end can only make ***static changes*** to the view. NO dynamic changes.
  + How ?? 
  + Should the frontEnd hold any state??
  
*(MENTION IN ANALYSIS:
TA: Create some GUI elements in the controller (these elements can also ***implement Observer*** and thus can ***hold state and perform comparisons***) like upload turtle image and pass into the view so when the user changes the image the view can just call the update method on the element. The controller then changes what it needs to).*


###Design Suggestions
- Draw TurtleImage extends ImageView that has an instance of the ID of the turtle that you can check when you do getChildren() and loop through all the children (TurtleImages and then get the ID). This way you dont have to delete and re-add
- The controller should not be implementing the changes in the state of the model. The backend implements these changes. The backend can use a another class to implement the changes (like whats happening now, but that would be called something else and not a controller). 
  + Use the idea that the backend can pass lambdas (where these are the functions that need to be implemented on the model) into the controllers .execute(backend::command) method that the backend has to have no idea about.
- For many turtles. You cannot use a boolean to set which are active... (What did he suggest in class?????)
  + Use an interface for SingleTurtle and another for GroupOfTurtles?? So that one can implement the methods for one turtle and the other can implement the methods (fd, bk, angle) for many turtles.
- **Use List for GUI elements with reflections... How to implement reflections with custom methods for each button??**
