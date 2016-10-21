package model.commands.TurtleCommands;

import model.commands.TurtleCommand;
import model.parser.ListOfCommands;

public class HideTurtleNode extends TurtleCommand{

	public HideTurtleNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		myTurtle.hideTurtle();
		return ZERO;
	}

}
