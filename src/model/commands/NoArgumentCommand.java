package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public abstract class NoArgumentCommand extends Command{

	public NoArgumentCommand(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		
	}

	public abstract double execute(Controller control);

}
