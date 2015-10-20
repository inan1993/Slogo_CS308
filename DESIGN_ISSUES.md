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
  
###Design Suggestions
- Draw TurtleImage extends ImageView that has an instance of the ID of the turtle that you can check when you do getChildren() and loop through all the children (TurtleImages and then get the ID). This way you dont have to delete and re-add
