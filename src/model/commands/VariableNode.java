package model.commands;

import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class VariableNode extends TurtleCommand{

	String myVarName;
	
	public VariableNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) {
		super(command);
		myVarName = command;
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}

}
