package model.commands;

import model.Controller;
import model.parser.ListOfCommands;

public class HideTurtleNode extends TurtleCommand{

	public HideTurtleNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute(Controller control) {
		//myTurtle.hideTurtle();
		return ZERO;
	}

}
