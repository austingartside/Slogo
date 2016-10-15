Austin Gartside(aeg36),
Katrina Zhu (kz37)

#Part 1
1. Our internal backend API makes it so that it should be easy to add commands. Ideally, the commands will be separated out into classes and be subclasses of its type (Math, boolean, Turtle). So to add a new one, the user need only put a class in the appropriate spot, and it will automatically be capable of being used by the user. Additionally the string version of it would need to be added to the set that contains the available commands so it can be error checked. Additionally it does a lot of the work for the overall design, so it should not need to experience a change in the layout as a result of front end changes. 

2. All of the parsing is part of the internal backend API, so that will prevent the frontend from needing to know how exactly the command is translated and executed. 
3. Some errors that might occur are passing no command, which should not throw an error but rather just not do anything at all. An error that would cause an exception to be thrown is improper syntax. That is either the user uses a command that does not exist or messes up and forgets a space or spells something wrong. The actual display of the error is part of the external API.

4. I think the amount of information it hides from the front end is good. This is good because for the project this makes it so that the parts can be worked on and debugged independently of other aspects of the project. Additionally actually reading through the code will be easy due to the separation of labor among many different classes. 

#Part 2
1. Use Cases:

The user does not input a command but tries to run the code

The user inputs the command fd 100 and runs the code

The user inputs the command fwd 100 and runs the code

The user inputs the command fd fd 100

The user inputs the command penup and then fd 10

2. Reflection is going to help me avoiding a giant if tree to figure out exactly what class needs to be instantiated or method needs to be called when translating string to commands.

3. I’m excited to work on the interpretation of commands because I think it very interesting to interpret another programming language. 

4. I’m also most worried about this part because I’m going to have to learn several techniques (such as reflection and an expression tree) to make it work.  