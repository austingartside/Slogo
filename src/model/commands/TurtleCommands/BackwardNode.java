package model.commands.TurtleCommands;

import java.util.List;

import model.commands.CommandNode;
import model.commands.TurtleCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class BackwardNode extends TurtleCommand{

	public BackwardNode(String command, ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);	
		addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
	}

	@Override
	public void execute() {
		
	}

}
