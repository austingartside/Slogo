package model.commands;

import model.commands.TurtleCommands.TurtleCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ConstantNode extends TurtleCommand{

	private double myVal;
	
	public ConstantNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) {
		super(command);
		myVal = Double.parseDouble(command);
		updateLocation(commandList);
	}

	@Override
	public double execute() {
		return myVal;	
	}

}
