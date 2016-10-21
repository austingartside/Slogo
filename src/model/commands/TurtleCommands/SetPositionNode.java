package model.commands.TurtleCommands;

import model.commands.CommandNode;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetPositionNode extends TurtleCommand{

	public SetPositionNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}