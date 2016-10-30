package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class HideTurtleNode extends NoArgumentCommand{

	public HideTurtleNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
		//commandList.updateLocation();
	}

	@Override
	public double execute(Controller control) {
		return control.getTurtle().hideTurtle();
		//return ZERO;
	}

}
