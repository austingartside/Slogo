package model.commands.ControlCommands;

import model.commands.Command;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ForNode extends ControlCommand{

	public ForNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker);
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker);
		
	}

	@Override
	public double execute() {
		return 0;
		// TODO Auto-generated method stub
		
	}

}
