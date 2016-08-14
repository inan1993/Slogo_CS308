#Introduction
The assignment is to create a simple implementation of an integrated development environment for Logo (a programming language). The IDE has a turtle that the users can command and interact with. It also has a number of options for customizing the user-interface. The project design is inspired by the MVC design patterns. The front-end and back-end share a reference to common data that the back-end can modify and the front-end uses to update the view. 

In the project design, the most flexible part is that we are able to support more objects on the screen, and support modification to object properties. In our design, shared memory will hold all the objects. When the program need to be extended for more than one turtles, we can implement new object classes and add the corresponding instance variables to shared memory. As the shared memory can be expanded as desired, it can accommodate different changes for future extension.

The backend of the design is split into parser and executor. The inner logics of parser and executor are closed. However, the APIs for calling parser and parsing user’s SLogo codes are open. Other programmers can use our parser and executor by passing strings to the API and get the execution results as the return value. 

#Overview
There are three main components to the design ie. back-end, Shared Data Objects and the front-end. The back-end modifies the data in the shared data objects while the front-end uses the information from the shared data objects. This is illustrated in the figure below.

![Diagram](https://i.imgur.com/Iomn7rN.png)

Figure: Overall data sharing and communication mechanism
Note: The direction of the arrow shows that the part where the arrow originates has access to the part where the arrowhead points to.

![Diagram](https://i.imgur.com/0CRwXOK.png)

We have created the design in such a way that there needs to be communication between back-end to back-end, front-end to front-end, front-end to back-end, and back-end to front-end. Therefore we have APIs for all these four types of communication.

![Diagram](https://i.imgur.com/yHHeDsE.png)

Figure: Design diagram of Backend

##Logic of the program
When the program starts, it will enter a loop of waiting for user’s input, executing the input and displaying the results. User’s input includes choosing items from the drop-down boxes on the screen, typing codes into the console, and selecting previous functions or commands from the drop-down boxes. After receiving the inputs, different event handlers will be triggered.

For events like user selects a new background color, or user selects a new type of language, the handler will directly call frontend-frontend API, without using the backend resources.

For event of entering commands and clicking ‘run’ button, the program will call backend API to pass the commands to the parser. After parsing the commands and detecting the possible syntax errors, the parser will generate a syntax tree. Then the parser will call the executor API to pass the syntax tree to executor. Executor will call modifying object API to modify the shared data objects according to the results when it traverses the syntax tree. If executor detects any runtime error during the running process, it will suspend the execution and directly return an error, otherwise it will return a success response. After backend return the response, the main program will call frontend API to read the shared data memory and update the screen.

##Backend classes
Class Parser is the parser of SLOGO codes. It will receive the codes from main program. Then the Parser will split the commands to different tokens. Then the Parser will parse the tokens to construct a syntax tree. During the process, if there are any errors detected, the Parser will create an error object and immediately return that to the main program.

The instance variable list<Token> is the result of regular expression matching. 
The instance variable response is the the result of parsing of execution.
The instance methods will be talked in detail in the following parts. 

Class Executor is the executor of the SLOGO code. It will receive the syntax tree from Parser. Then the Executor will traverse the syntax tree and recursively run each node. If there are any errors detected, the Executor will create an error object and immediately return that to the Parser, and then successively to the main program. Otherwise, the Executor will modify the shared data memory. It will also create a success response and return it to Parser. The running result will be generated in the response.

Class Node is a closed abstract class for the syntax tree. Each variable, command, or control structure will have its own node class that extends the super Node. Node class will hold a name string instance variable to record the name of the token. According to the specific function of the token, node will hold a list of node children and a run method to execute based on the results of each child.

Class Response is a closed abstract class for both backend and frontend. Currently it will have two subclasses: Error and Success. 

##Frontend Classes
See User Interface, below.

#User Interface
The diagram shows the simple layout of how the user interface will look like. It includes the display box for turtle’s movement as well the view boxes for variables, functions and command history. 

Currently, there are three ways to input. The first one is inputPrompt where the user types the commands and presses the enter tab to send the command. the second way to input is to click the dropdown menu to access the resource folder to select the image for turtle. The third way to input is click the dropdown to select the color choice for either pen or background from the lists available in the dropdown.

In case of certain errors, the error message will be displayed in the error message box. this will coordinate with the SlogoModelController and get the response from the parser.

The classes that are required for the front-end are listed below:

- Main
- SlogoModelController
- SlogoView
- TurtleViewBox
- Abstract class Dropdown
- BackgroundColorDropdown
- PenColorDropdown
- LanguageSelectionDropdown
- TurtleImageSelectionDropdown
- Abstract class Tabs
- HelpTab
- ClearCommandPrompt
- SendUserInput
- Abstract classViewBox
- VariableListBox
- FunctionListBox
- CommandHistoryBox
- Abstract class DisplayBox
- CommandPromptDisplay
- MessageDisplayDialog

![Diagram](https://i.imgur.com/C9VDDxG.png)

Figure: User Interface layout

The functions of each of the dropdown menus, tabs and boxes in the above figure are described below:
File dropdown: For this sprint it will let users to select turtle images. This dropdown can be extended to include other features for future sprints.
Language dropdown: This will have different language options for user to choose from. Choosing a particular language option will execute the program in that particular language.
Help tab: This will link the user to a HTML page related to Slogo, but can be expanded in future sprint to include links to other features .
Background dropdown: This feature helps user to select from 5 different colors in the dropdown menu, which will change the background color of the turtle’s movement screen accordingly.
Pen dropdown: This feature enables user to select from 5 different colors in the dropdown menu to change the pen color.
Variables box: This will include the list of variables used by the user. This will be scrollable.
Functions box: This will include the functions used by users or defined by users. This will also be scrollable.
Command history box: This will include the list of commands that the user has executed. This too will be scrollable.
Turtle’s movement screen: This is the main box where the turtle executes its movement according to the user input. This will have wrap-around feature.
Message screen: Error/success messages and the results to mathematical calculations will be displayed here.
Clear tab: User will be able to clear the contents in command box by pressing this tab.
Command box: Users enter the command in this box.
Enter tab: Only by pressing this tab, the user can execute the commands entered in the command box.   


#Design Details
- Protected void SharedDataObj.addTurtle()
- Protected void SharedDataObj.clearTurtle()
- Public Turtle SharedDataObj.getTurtle() 
- Protected void Turtle.setImage()
- Protected void Turtle.addPen()
- Protected void Turtle.setColor()
- Protected void Turtle.setAngle()
- Protected void Turtle.setPosition()
- Protected void Turtle.clearPen()
- Public Pen Turtle.getPen()
- Protected void Pen.setColor()
- Protected void Pen.addLine()

This API is designed for Executor to update the shared data objects. It can be extended in the following ways:
- Support adding multiple Turtles, and each of them has different image or shape.
- Support adding multiple Pens of one Turtle, and each of them has different color or Thickness.
- Support adding other type of data objects to the screen. We make SharedDataObj hold more instance variables and add the corresponding getters and setters. For example, if a fish (something like turtle) is added to the screen, we just make the SharedDataObj contain an instance variable of fish.

#####Response Parser.setCommandString(String s) // Frontend calls Backend

When the user click ‘run’ button, the mouse event is triggered. At this time the event handler will call this API. SlogoModelController will pass the string of commands that user enters to Parser. After the parsing and executing process in the Backend, the SlogoModelController will get the return value as a Response object. 
This API can be extended for the following features:
The user chooses a history command he ran previously in the drop-down box. Then the event handler will also call this API, pass the string of command to Parser and get the Response.
The user chooses a history function he ran previously in the drop-down box. Then the event handler will let him enter the necessary arguments. After that the event handler will also call this API, pass the string of function and command to Parser and get the Response.
	
#####Response Executor.execute(Node n) //Parser (Backend) calls Executor (Backend)

This API will support two features: let turtle act interactively when user enters text commands, and let user see errors that may result from entered commands in a user friendly way.

Parser will hold an instance variable of Executor. When calling the execute function, Parser will pass the root of the syntax tree to the executor. Executor will recursively execute each node in the syntax tree. According to the specific syntax of each node, the Executor might update the shared data objects by calling the first set of APIs.

If there are any runtime error, the Executor will create an Error Response and immediately return that error to the Parser. If every node in the syntax tree is traversed successfully, the Executor should create a Success Object. The Parser will receive the Response and successively return the Response as the return object of setCommandString API.


#API Example Code
The following "sequence of code" shows how the given use case is implemented using our program:

<i>The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and has the command added to the environment's history.</i>

```java
SlogoModelController:
	myParser.setCommandString(“fd 50”);
Parser:
	setCommandString(“fd 50”){
	//if(detectSyntaxError(“fd 50”)==true)
		myResponse = new Error(“invalid input”);
	//otherwise
		TreeNode root = generateSyntaxTree(“fd 50”);
		myResponse = myExecutor.execute(root);
	}
Executor:
	execute(root){
	for(root each:root.children())
	{		
		each=each.run();
		if(runTimeError())
		{
			response = new Error();
			return response	
		}
	}
	response = new Success(root.value);
	return response;
}

SlogoModelController:
	display(myParser.getResponse());

//If succes response
SlogoModelController:
	turtle.draw();
	pen.draw();
SlogoModel
	updateView();
// Else handle response appropriately
```

#Design Considerations
We spent a considerable amount of time discussing the APIs we would be implementing and how we would be using them. To better understand the control flow we sketched it out on the white-board. We realized then that we might have a problem, which led us to reconsider our original design.

We decided to use three main components for design ie. back-end, Shared Data Objects and the front-end. This was thought to be a good design because Shared Data Objects (turtle and pen) would be shared among both front and back end, and would be populated by back-end. This will then be used by the front-end to draw the necessary movements of turtle. Hence, this design makes the back-end and front-end flexible as well as independent of each other.

The back-end is also divided into two sections. One of the section looks after the parsing the command that the user enters. It then assigns those parsed objects to the node or leaf of the tree. We are using tree structure to analyse the data in the back-end as it is easier traversing through it. Other section of the back-end uses those objects in the tree to generate specific functions and generate response for the turtle and pen object depending on the command. Hence, the back-end is completely independent of the front-end and there is a communication mechanism between the sections in back-end too.


#Team Responsibilities
#####Front End: 
Abhishek Upadhyaya Ghimire, Inan Tainwala

#####Back End: 
Logan Rooper, Inan Tainwala, Wanning Jiang, Connor Usry


