##Part 1
- What about your API/design is intended to be flexible?
    1.  If another command is added and it has new function (e.g changing the color of the screen / turtle), we will add a sub-node for this new command, and a new instance variable into the Status(cw272) / ShareDataObj(wj43), without changing the prototype of the API.
    2.  If we want to support undo / redo, then cw272's team will not change the design, while wj43's team has to change their design. The difference is that cw272 keeps the entire sequence of polylines and keeps a sequence of pointers pointing to the time stamps. wj43's team's sharedDataObj only keeps the difference between run buttons. However, wj43's team keep a list of historical commands. In this round, cw272 wins in time, while wj43 wins in space! A better design will be depend on the requirement.

<!-- - How is your API/design encapsulating your implementation decisions? -->
- What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?
    1.  syntax exception
    2.  lexicon exception
    3.  language not found exception
A better design is to encapsulate these errors into a response object and return that back. This response object be generated when some part of the backend catch the error throwed by other part of the backend, but the response will be complete for the frontend, which means frontend will have no ideas of the exception that is thrown and caught behind the scene. 
- Why do you think your API/design is good (also define what your measure of good is)?
    * 'Good' is a measurement of how much the prototype need to change when new features are added.
    * We both think our APIs are good, because there will be very rare changes. The APIs are based on logic, instead of the functionalities, so they are abstract enough.
<!-- Both people should complete Part 1 before continuing on to Part 2. -->

##Part 2
- Demo what you currently have running (it could be anything, but it should definitely be something).
    wj43's team have some frontend frameworks. wc272's team have frontend almost done. Backend: nothing. However, we will start regular expression matching (token translation) tonight!

- Come up with at least four use cases for your part (it is absolutely fine if they are useful for both teams).
    1.  user enters a bunch of correct commands. [generate a list of nodes]
    2.  user misspells a single letter in a variable. [semantic exception]
    3.  user enter a wrong command after forward. [syntax exception]
    4.  user undo.

What feature/design problem are you most excited to work on?
    node factory.

What feature/design problem are you most worried about working on?
    language translation (or nothing).
