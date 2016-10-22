package model.commands;

import java.util.Map;

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
	public double execute(Map<String, Double> variables) {
		return 0;
		// TODO Auto-generated method stub
		
	}

}
