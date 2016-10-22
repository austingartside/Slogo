package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class CommandNode extends Command{

	String myVarName;
	
	public CommandNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) {
		super(command);
		myVarName = command;
		updateLocation(commandList);
	}

	@Override
	public double execute(Controller control) {
		// TODO Auto-generated method stub
		return 0;
	}

}
