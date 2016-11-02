package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public abstract class LoopCommand extends ControlCommand{

	public LoopCommand(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		checkForListStart(commandList, control);
		commandList.updateLocation();
		isVariable(commandList.getCommand(), control);
	}

	@Override
	public abstract double execute(Controller control);

}
