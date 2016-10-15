William Xiong and Daniel Chai
#### Part 1

1.  You can update any state- no restricted to specific states. This is done through the updateState() method.  
    You can update any object, not just a turtle object. 

2. The front end does not need to see the updating that is being done. The front end only takes in necessary information from the backend.  
3. Some exceptions include an invalid command. When this happens, we will catch the exception and display an error dialog box.  
4. This design is good because it encapsulates all necessary data and only gives the minimum data to the front end to update the program.  
    This is design is also flexible because it allows us to change any number of states.
    
#### Part 2
1.  The user types fd -40 and watches the turtle move backwards.
    The user types the command to pen down and watch the turtle draw a path.
    The user types in a math command such as 4 + 5 and sees the result display in the command box.
    The user types in a command to go out of bounds and the program handles the error accordingly.
    The user types in an invalid command and the program displays an error box.
2.  Binding and Observables will be useful in transferring information from Model to View.
3. I am most excited about working on data input and command input.
4. Parsing will be hard to implement.