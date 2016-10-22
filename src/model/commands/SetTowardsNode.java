package model.commands;

import java.util.Map;

import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetTowardsNode extends TurtleCommand{

	public SetTowardsNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute(Map<String, Double> variables) {
		return 0;// TODO Auto-generated method stub
	}

}
