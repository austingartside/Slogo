package model.commands.ControlCommands;

import model.commands.CommandNode;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ForNode extends ControlCommand{

	public ForNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		moveThroughList(commandList, nodeMaker);
		moveThroughList(commandList, nodeMaker);
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
