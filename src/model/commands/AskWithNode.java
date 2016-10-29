package model.commands;

import java.util.HashSet;
import java.util.Set;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class AskWithNode extends ControlCommand{

	public AskWithNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		checkForListStart(commandList, control);
		moveThroughList(commandList, nodeMaker, this, control, this.getName());
		this.addChild(new BlankNode(commandList, nodeMaker, control));
		checkForListStart(commandList, control);
		moveThroughList(commandList, nodeMaker, this, control, this.getName());
	}

	@Override
	public double execute(Controller control) {
		//child 0 is the expression, so execute that expression for each turtle i guess?
		return 0;
	}

}
