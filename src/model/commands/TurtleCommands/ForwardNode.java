package model.commands.TurtleCommands;
import java.util.*;

import model.commands.Command;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ForwardNode extends TurtleCommand{
	
	public ForwardNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);	
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));	
	}

	@Override
	public double execute(Map<String, Double> variables) {
		//myTurtle.move(MINUS*this.getChild(FIRSTENTRY));
		return getChild(FIRSTENTRY, variables);
	}
	
	

}
