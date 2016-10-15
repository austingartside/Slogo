gac19 wpl5

PART 1
=====

1. We intend to make our program flexible by making it really simple to add new components. By just having the layout class place it  and creating a new class to add that component into the display screen. It might also be necessary to update the controller depending on if it interacts with any other parts. 

2. Each component will be in its own class. This means that each component will be encapsulated from having any interactions with other components other than through the controller. By this logic, we should never have to update the class for a component if new parts are added, but only update the controller if it interacts with the new component.

3. The controller class that we have designed to handle interactions in between the front and back end should catch these errors and send it to the front. The controller will determine what to do with this error and what to display to the user. It then sends to the front what actually needs to be displayed so the front can execute it.

4. I think the design I came up with my team is good because it allows the program to be extended for any new component that is added as well as encapsulated from the rest of the project. Each new component can be added with minimal update of the layout class. If it were perfectly implemented I would say there would be no updating of the layout class necessary and only update the controller/add a new class for the component.


PART 2
=====

1. Use cases are as follows
	1. User clicks on a function in the functionStorageBox and it must update the text in the userInput box
	2. User clicks on a tab that switches the view from history to possible commands
	3. User changes the language to be used from the toolbar at the top
	4. User inputs a command for the turtle that must be sent to back end for parsing
	5. User opens up the help screen HTML file

2. By using binding we will be able to only have to send the information through the controller one way. The info sent to the back will be interpreted and when it is done, because of binding, the front end will be automatically updated.

3. I'm most excited to work on the actual turtle module because it is the most important, most interactive, and from the looks of it the most challenging. 

4. I'm most worried about the turtle module as well because it has so many different cases. All these different cases could be overlooked and it will additionally require advanced features such as binding or reflection. This will be challenging and what I will have to do the most reading on.
