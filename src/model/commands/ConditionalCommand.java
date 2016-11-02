package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public abstract class ConditionalCommand extends ControlCommand{

	public ConditionalCommand(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
		checkForListStart(commandList, control);
	}

	@Override
	public abstract double execute(Controller control);

}
