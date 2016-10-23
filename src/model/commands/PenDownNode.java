package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class PenDownNode extends TurtleCommand{

	public PenDownNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
	}

	@Override
	public double execute(Controller control) {
		control.getTurtle().penDown();
		return ONE;
	}

}
