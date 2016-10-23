package model.commands;


import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class XCoordinateNode extends TurtleCommand{

	public XCoordinateNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
	}

	@Override
	public double execute(Controller control) {
		return 0;	
	}

}
