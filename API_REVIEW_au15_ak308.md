Team Members:
--------------
Ankit Kayastha (ak308) and Abhishek Upadhyaya Ghimire (au15)

Front-End API review
==========

Part 1
---------
* What about your API/design is intended to be flexible?
<p>The ability to add components in the GUI makes it flexible.</p>
* How is your API/design encapsulating your implementation decisions?
<p>It encapsulates implementation decision by being independent of the back-end and being flexible to changes in future.</p>
* What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?
<p>The error handling is done by the back-end. There might be error while the user types in incorrect command, but the sole job of front-end is to display the error message rather than analyzing it.</p>
* Why do you think your API/design is good (also define what your measure of good is)?
<p>My API is flexible to changes and modification later. Hence I think it is good design.</p>

Part 2
-------
* Demo what you currently have running (it could be anything, but it should definitely be something).
* Come up with at least four use cases for your part (it is absolutely fine if they are useful for both teams).
	- User chooses a new background color
	- User changes the language
	- User changes the pen color
	- User links to the help page
* What feature/design problem are you most excited to work on?
<p>I am excited to come up with a great GUI with flexible design components.</p>
* What feature/design problem are you most worried about working on?
<p>I am worried about being able to change the state of the turtle depending on the change in user command. This depends on the communication between back-end and front-end.</p>
