package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class TurtlesNode extends NoArgumentCommand{

	public TurtlesNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
//		commandList.updateLocation();
	}

	@Override
	public double execute(Controller control) {
		return 0;
	}

}
