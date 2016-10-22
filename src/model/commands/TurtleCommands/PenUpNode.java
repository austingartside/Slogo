package model.commands.TurtleCommands;

import model.parser.ListOfCommands;

public class PenUpNode extends TurtleCommand{

	public PenUpNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);
	}

	@Override
	public double execute() {
		//myTurtle.penUp();
		return ZERO; 
	}

}
