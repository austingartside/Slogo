package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public abstract class AskCommand extends ControlCommand{

	public AskCommand(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		checkForListStart(commandList, control);
		moveThroughList(commandList, nodeMaker, this, control, this.getName());
		this.addChild(new BlankNode(commandList, nodeMaker, control));
		checkForListStart(commandList, control);
		moveThroughList(commandList, nodeMaker, this, control, this.getName());
	}

	@Override
	public abstract double execute(Controller control);
	

}
