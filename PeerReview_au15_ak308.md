Peer Code Review
================

<p>Written by: Ankit Kayastha (ak308)</p>
<p>About: Abhishek Upadhyaya Ghimire (au15)</p>


<p>After reviewing Abhishek's class that handled the creation of the main GUI components, I think the main thing that could be improved upon is the idea of the Single Responsibility Principle. In his class currently, all the different components of the User Interface are being created in the same class. So, it might be best if each component is separated into its own class/package so they are only responsible for one thing at a time. This will also help to reduce the size of the class, which is currently about 200 lines of code. So, in terms of refactoring, I think this is something that can be done with not too much work, but in the end, will be very useful and beneficial for the project. The main concept here that is being worked towards is the Single Responsibility Principle, which is the idea that each entity (class, method, etc) should only be responsible for doing one thing or accomplishing one task.</p>
