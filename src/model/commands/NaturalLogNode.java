package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class NaturalLogNode extends OneArgumentCommand{

	public NaturalLogNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}
	@Override
	public double execute(Controller control) {
		return Math.log(executeChild(FIRSTENTRY, control));
		
	}

}