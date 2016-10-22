package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class IfElseNode extends ControlCommand{

	public IfElseNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker);
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker);
	}

	@Override
	public double execute(Controller control) {
		return 0;
		// TODO Auto-generated method stub
		
	}

}
