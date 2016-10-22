package model.commands.TurtleCommands;

import java.util.Map;

import model.parser.ListOfCommands;

public class PenDownNode extends TurtleCommand{

	public PenDownNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute(Map<String, Double> variables) {
		//myTurtle.penDown();
		return ONE;
	}

}
