package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class HideTurtleNode extends TurtleCommand{

	public HideTurtleNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute(Controller control) {
		control.getTurtle().hideTurtle();
		return ZERO;
	}

}
