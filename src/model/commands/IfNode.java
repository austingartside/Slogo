package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class IfNode extends ControlCommand{

	public IfNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker);
	}

	@Override
	public double execute(Controller control) {
		return 0;
		// TODO Auto-generated method stub
		
	}

}
