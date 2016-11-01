package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class CosineNode extends OneArgumentCommand{

	public CosineNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}
	@Override
	public double execute(Controller control) {
		return Math.cos(executeChild(FIRSTENTRY, control));
	}

}
