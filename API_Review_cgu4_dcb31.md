**Note: Late Submission... completely forgot to push to master. Talked with Professor, who said to just push now.  You can check my partner's master (dcb31) for proof we worked on it on time in recitation. Thanks! 
##Recitation Peer Code Review Evaluation of Slogo
####Connor Usry(cgu4) and Collin Bachi (dcb31)

=============

####API Review:

Part 1
---------
My team (team 17) designed our API in order to expand/add upon commands to manipulate the SharedObjectModel for later extensions of the project.  The API design in intended to be encapsulate these desicions since the front-end and back-end are completely seperate in their operations. Therefor if the extensions in the future only affect the storage (back-end) of states or displaying of states (front-end) than we can change the correct side respectively without modifying the other's. Error handling is handled by the backend, such as when a user types in an incorrect command. Then the front-end will display this error immediately after the parser or the executor finds the fault. The API design is solid but definitely needs refinement as we progress . 


Part 2
---------
 
Since I am working on the SharedDataObjects Model and the API communication I wasn't able to demo anything, but was able to show the code and skeletons I have written up at this point. 
Four use cases for my section are...

1. Receive execution command of moving the turtle foward, reverse...etc.
2. Receive execution command of picking up or setting down the pen.
3. Receive execution command of changing the color (direct this command to frontend).
4. Receive execution command of clearing the stage (direct this command to frontend to clear the view).

I am most excited on working on deciding which information is executed by the front end or backend, and the SharedobjectModel's role in both (since this has yet to be refined).
I am least excited about working on the Pens, since storing of this information correctly can make extension in the future either very difficult or easy depending on how I decide doing so.

