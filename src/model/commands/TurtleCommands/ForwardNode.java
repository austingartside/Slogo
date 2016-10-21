package model.commands.TurtleCommands;
import java.util.*;

import model.commands.CommandNode;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ForwardNode extends TurtleCommand{
	
	public ForwardNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);	
		addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
				commandList));	
	}

	@Override
	public double execute() {
		//myTurtle.move(MINUS*this.getChild(FIRSTENTRY));
		return this.getChild(FIRSTENTRY);
	}
	
	

}
