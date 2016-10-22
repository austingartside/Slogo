package model.commands.TurtleCommands;

import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class HeadingNode extends TurtleCommand{

	public HeadingNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) {
		super(command);
		updateLocation(commandList);
	}

	@Override
	public double execute() {
		return 0;// TODO Auto-generated method stub
		
	}

}
