package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;
/**
 * @author austingartside
 * 
 */
public abstract class TwoArgumentCommand extends Command{

	public TwoArgumentCommand(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}

	@Override
	public abstract double execute(Controller control);

}
