package model.commands.ControlCommands;

import model.commands.Command;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class DoTimesNode extends ControlCommand{

	public DoTimesNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		checkForListStart(commandList);
		updateLocation(commandList);
		isVariable(commandList.getCommand());
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
		updateLocation(commandList);
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker);
		
	}

	@Override
	public double execute() {
		return 0;		
	}

}
