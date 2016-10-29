package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class TurtlesNode extends Command{

	public TurtlesNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
	}

	@Override
	public double execute(Controller control) {
		// TODO Auto-generated method stub
		return 0;
	}

}
