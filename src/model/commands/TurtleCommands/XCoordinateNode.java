package model.commands.TurtleCommands;

import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class XCoordinateNode extends TurtleCommand{

	public XCoordinateNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) {
		super(command);
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
