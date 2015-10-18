CompSci 308: Slogo Team 1 Design Review
===================

**John Dai (rd122) Team 1**
**Inan Tainwala (it15) Team 17**


####Part 1
- Team 1 implements an MVC architecture.
- Their data is stored in the controller.
- External API (to move turtle, update history etc) currently in front-end. Moving to back-end.
- API calls to the controller. Through which all the changes flow. It calls the front-end on state changes.
- For adding a turtle you can pass a new turtle object. For changing a turtle you pass an ID.
- The front end catches all the errors so that it can display it to the user without breaking the program. 


####Part 2

- Basic windows for the front end. Backed has one command already working.

- Use cases
	+ Add new turtles? Command to backend. Which then creates a new turtle instance. Add to the list and notify the controller.
	+ Draw Lines? Path objects are created on moving turtles. Passed to the controller which calls the front end. 
	+ Changing background? Front end button. Palette object which is created by the main GUI class. The color-picker and the turtle display have a reference to it. Listener on the palette object.
	+ Update History? Keeps the string of the command even after parsing command to tree. Implement syntax highlighting.

- Excited changing colors and visual stuff. Worried about the API stuff and handling updating the view.
