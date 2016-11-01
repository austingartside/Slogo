package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class PiNode extends NoArgumentCommand{

	public PiNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}
	@Override
	public double execute(Controller control) {
		return Math.PI;
	}

}
