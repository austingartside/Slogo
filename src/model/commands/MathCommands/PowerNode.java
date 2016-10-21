package model.commands.MathCommands;

import model.commands.CommandNode;
import model.commands.MathCommands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class PowerNode extends MathCommand{

	public PowerNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
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
