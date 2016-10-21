package model.commands.TurtleCommands;

import model.commands.TurtleCommand;
import model.parser.ListOfCommands;

public class ShowTurtleNode extends TurtleCommand{

	public ShowTurtleNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		myTurtle.showTurtle();
		return ZERO;
	}

}
