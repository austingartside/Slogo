package model.commands;

import java.util.HashSet;
import java.util.Set;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class AskWithNode extends AskCommand{

	public AskWithNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}

	@Override
	public double execute(Controller control) {
		//child 0 is the expression, so execute that expression for each turtle i guess?
		return 0;
	}

}
