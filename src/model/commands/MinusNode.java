package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class MinusNode extends OneArgumentCommand{

	public MinusNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}
	@Override
	public double execute(Controller control) {
		double expr1=executeChild(FIRSTENTRY, control);
		return -1*expr1;
	}

}