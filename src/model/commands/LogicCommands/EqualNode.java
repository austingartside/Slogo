package model.commands.LogicCommands;

import model.commands.CommandNode;
import model.commands.LogicCommands.LogicCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class EqualNode extends LogicCommand{

	public EqualNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
