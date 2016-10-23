package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class IsPenDownNode extends TurtleCommand{

	public IsPenDownNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
	}

	@Override
	public double execute(Controller control) {
		return 0;// TODO Auto-generated method stub
		
	}

}
