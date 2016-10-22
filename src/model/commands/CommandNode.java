package model.commands;

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
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}

}
