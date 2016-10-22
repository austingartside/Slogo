package model.commands;

import java.util.Map;

import model.parser.ListOfCommands;

public class PenUpNode extends TurtleCommand{

	public PenUpNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);
	}

	@Override
	public double execute(Map<String, Double> variables) {
		//myTurtle.penUp();
		return ZERO; 
	}

}
