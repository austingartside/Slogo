package model.commands.TurtleCommands;

import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class IsPenDownNode extends TurtleCommand{

	public IsPenDownNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) {
		super(command);
		updateLocation(commandList);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
