**Introduction**

For this project we are trying to create an Integrated Development Environment  that supports the SLOGO Programs using Java. The program should be able to receive text commands that control a turtle and create actions on a GUI. These commands will be translated to actions, which will be sent back to the front-end for visualization. Additionally, it will store these commands and display them to be used for later use. Our ultimate goal is to have a flexible program, that is it should be able to add new commands easily without changing the overall structure of the program. The display should also be capable of adapting to different situations that might arise. Additionally, we want our API’s to be extendable, such that other programs would be able to use them. For example make a display that could be used in other programs. In terms of architecture, the frontend should not be able to see the parsing done in the backend. Since more commands could be added, the translation of them will be open but the actual parsing of test is closed. Also the controller classes should be closed, since they transfer data and should not be accessed by anyone. Parsing through text would be closed since it is the same for all commands. The display, however, is a part of the project that should be open since a new update or command would change what needs to be visualized. 

**Design Overview**

Internal front end: The Internal Front end API will contain features and methods only necessary within the Front end. Features such as displaying the turtle and its associated attributes by using the information passed by the Model to View. Classes for this part include a class for each type of feature (button, combobox, textbox)

Internal back end: This internal API will possess features that will allow communication between different backend modules, such as the ModelTurtle, the CommandParser, and the CommandBank. The ModelTurtle controls the behavior of the turtle, the CommandParser takes in and interprets commands, and the CommandBank contains a list of all commands. Classes that might be a part of the internal backend are the classes for the types of commands as well as the subclasses that have the actual commands. 

Public backend: This external API will contain features that the View needs to communicate with the Model, such as location, orientation, statistics, etc. in order to update images. 

Public frontend: The public frontend will be responsible for initialising and setting up the stage and screen which have to interact dynamically with the backend. In addition, the public front end will have to pass the command or instruction inputted to the View to the Model as well as any mouse or keyboard events if necessary.

**User Interface**

Users will interact with our program through the use of various menus and toolbars. There will be a menu for what tab you would like to have open on the side of your screen (history, possible commands, etc.) and there will be a toolbar along the top with some pre-programmed moves. We will have an output box for any math/words that the turtle does not need to know about. History will allow the user to click on the previous command and repeat it. Possible commands is just a library of all commands that someone can do and how to use them. The user will get a report if they put in a command that is not valid, or use a valid command with the incorrect/null command arguments.

**API Details**

Model to Model: This API is in charge of updating the state of the program, such as updating the location and the orientation of the turtle, creating paths/lines, etc. This data will be used by the View to draw the updated state. This API can be easily extended to include more commands and different states simply by adding the necessary methods and classes. It takes in information from the View to Model API, parses the information, updates the necessary states, and passes the information to the Model to View API. 
Necessary classes are the CommandParser class, the Turtle class, an Execution class, and a set of classes for each type of command (i.e. one class for turtle commands, one class for math commands, etc.). The CommandParser class takes in commands and parses it, and passes the parsed commands to the Execution class for it to update necessary states. There are different classes for each type of command to separate functionality and improve organization. 

```java
/**
* This interface is responsible for interpreting and parsing commands and updating the state
* of the program accordingly. 
*/
public interface ModelToModel{
	//change the location of the turtle object
	public void updateLocation();
	//update the angle/orientation of the turtle object.
	public void updateOrientation();
	//change images or add images to the screen
	public void updateImage();
	//return the location the turtle was last at
	public Point getPrevLocation();
	//parse the command passed in from the view.
	//This will throw an Exception if the command is not valid. 
	public void interpretCommand();
	//return the command that was chosen once it was parsed.
	public Command chooseCommand();
	//return the current location of the turtle
	public Point getCurrLocation();
	//update any other states of any other object in the program. 
	public void updateState();
	
	//add the specified command to a list of previous commands
public void addToHistory(Command c);
}
```


Public backend: This Front end API is responsible for taking the information processed by the model and passing it along to the View module so that it can be displayed. It takes in a processed set of parameters, such as the co-ordinates of the of the object display as well as the boolean parameters for different conditions such as pen-up,pen-down or display-object. In addition, it will have to use the information passed by the model to display any error conditions. 
```
public interface ModeltoViewInterface(){
	// Takes in a boolean condition to choose whether or not the display should draw a line
public void usePen(boolean penState);
// Takes in new co-ordinates to refresh the objects location
public void updateLocation(double xCor, double yCor);
//Outputs the error condition
public void outputError();
// Takes in orientation value to refresh the angle or orientation of the object
public void updateOrientation(int angle);
// Allows statistics to be displayed
public void printStatistics(double statistics);
}
```
View to View:  This API will show interactions between different UI elements and also display turtle movement onto the screen. It will handle any dynamics of the screen changing or being altered by UI. This will also be responsible for outputting into the Math/word output box that does not depend on the turtle. It should be able to be extended to include more UI and commands that can interact with the text box and the display of the turtle. It should also be able to have all of it’s tool bars extended as well as any buttons or menus. 
Necessary classes are the Display class, the Layout class, and a UIInteractionHandler class. The Layout class will be in charge of setting up the screen for the user to use. Then the display class will be in charge of showing new/updated information on the screen. The UIInteractionHandler will take something the user did and figure out if some other part of the display should be updated because of it. 

```java
public interface ViewToView{
	//This will update the canvas whenever called upon
	public void updateCanvas();
	//This will update the math box if new data was outputted
public void updateMathBox();
	//This will change what tab of the menu you are on and fix the display accordingly
public void changeMenuTab();
//This will update the input text if a certain command is clicked by user.
public void updateInputText();

}
```

Public front end:
The public front end class will include the elements of the front end that would be extendable to other projects. That is it will include the creation of different visuals that might be used in any project. This includes classes for creating the screen, creating a root, and allowing the creation of any of the different features. Each of the different features would be its own subclass, but all of these could be extended to another project needing a visual (subclass examples include button, combo box, text box etc.)

```
/** 
 * @author austingartside
 * This interface provides the methods that need to be implemented by the backend that relate directly to the
 * visual created on the front end.
 */
public interface ViewToModelInterface {
	//Creates a stage to be used for the visualization
	Public void makeScreen();
	
	//actually creates the root that will allow the user
	Public void createRoot();
}
```

**API Example Code**

The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to the environment's history.
ViewtoModel
	passString(String command);
ModeltoModel
interpretString(String command);
ModeltoModel
interpretCommand(String command);
ModeltoModel
chooseCommand(String command);
ModeltoModel
setLocation();
ModeltoModel
	updateHistory()
ModeltoView
	updateLocation()
ModeltoView
	displayHistory();
ViewtoView
	updateCanvas();

	
Grant’s use case: A user clicks on a history command. This command puts the already used text into the textbox again without the user typing it. User then runs command and command is not added to history because it was the most recent one.

ViewtoView
	updateInputText(String command);
ViewtoModel
	passString(String command);
ModeltoModel
interpretString(String command);
ModeltoModel
interpretCommand(String command);
ModeltoModel
chooseCommand(String command);
ModeltoModel
setLocation();
ModeltoView
	updateLocation()
ViewtoView
	updateCanvas();


Austin’s use case: A user puts in the command fd fwd 50. The fwd command does not exists, so the parser will split this into separate strings, then check to see if the command is valid and return an error saying it is not.

//Public front end
getString()
//Internal back end
interpretString()Back end
//commandList HashSet created from Resource file
//Internal Back end
If isValidCommand()
	commandList.add(command);
//Public back end
Else{
	outputError();
}
Output: Improper input, command fwd cannot be found

Bill’s use case: A user types in the command fd 3000, moving the turtle off the grid. The parser will parser the number, check the number to see if valid, and then catch the error and handling it appropriately. 
getString()
interpretString()
commandList()
if(locationInBounds())
updateLocation()
else{
//handle error or do something
}

Guhan’s Use Case: The user inputs add 20,30. The user clicks enter and sees the resulting operation outputted in a different textbox. The history is also updated.
ViewtoModel
	passString(String command);
ModeltoModel
interpretString(String command);
ModeltoModel
interpretCommand(String command);
ModeltoModel
	checkforError();
ModeltoModel
chooseCommand(String command);
ModeltoModel
completeOperation();
ModeltoModel
	updateHistory();
ModeltoView
	displayOperation();
ModeltoView
	displayHistory();


**Design Considerations**

When considering the design we had a couple ideas. We understood the overall structure of the project, that is text is inputted, parsed, translated to a command, executed, and then visualized. At one point we considered just having a front end and back end with no controller or middle man. Although this makes communication a little faster, it makes it harder to store information that needs to be passed such as the history and turtle position. We opted to have a controller of sorts that will act as a middleman between front and back end (although it will be created in the back), so that it can easily store and update info as well as communicate changes between the two sides. The primary dependency we have is that the frontend acquires correct information from the backend. Our frontend should have no processing and our backend should have no dependency on the frontend. 

**Team Responsibilities**

Grant: frontend. Will be working on the static part of the display as well as any dynamic internal parts. Will also help out with any external parts as needed (like the history or the turtle updating)
Guhan: Backend. Will be responsible for processing the commands to update the turtle object and pass on the parameters that will be utilised by the front end.
Austin: Austin will be working on the backend. He’s going to be focusing on receiving the text input and parsing it to create a tree of commands. He will focus on communication while Guhan will focus mostly on the internal aspects of the backend. 
Bill: working on dynamic part of front end, communicating with the backend, helping out with parsing commands. 
