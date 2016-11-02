package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;


public class ClearScreenNode extends NoArgumentCommand{

	public ClearScreenNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}

	@Override
	public double execute(Controller control) {
		double temp= control.getTurtleControl().getTurtle().clearScreen();
		control.getTurtleControl().refresh();
		return temp;
	}

}
