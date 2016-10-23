package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class PenUpNode extends TurtleCommand{

	public PenUpNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
	}

	@Override
	public double execute(Controller control) {
		//myTurtle.penUp();
		return ZERO; 
	}

}
