package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.ListOfCommands;

public class PenUpNode extends TurtleCommand{

	public PenUpNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);
	}

	@Override
	public double execute(Controller control) {
		//myTurtle.penUp();
		return ZERO; 
	}

}
