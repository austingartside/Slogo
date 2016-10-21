package model.commands.ControlCommands;

import model.commands.CommandNode;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class RepeatNode extends ControlCommand{

	public RepeatNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		moveThroughList(commandList, nodeMaker);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
