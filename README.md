# slogo
A development environment that helps users write SLogo programs.

####Desgin Considerations
- The slogoModel should be used as the interface we use to access the sharedMemObject.
(So the slogoModel can hold this object as an instance and use helper methods from another class to
modify the sharedMemObject - like a TurtleManager class or a CommandHistoryManager class).

- The **backend and the frontend** will both have a reference to this SlogoModel. 
