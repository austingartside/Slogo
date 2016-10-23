package model.commands;

import model.Controller;
import model.parser.ListOfCommands;

public class PenDownNode extends TurtleCommand{

	public PenDownNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute(Controller control) {
		//myTurtle.penDown();
		return ONE;
	}

}
