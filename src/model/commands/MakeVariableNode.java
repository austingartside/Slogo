package model.commands;

import java.util.Map;

import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class MakeVariableNode extends ControlCommand{

	String variableName;
	
	public MakeVariableNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		isVariable(commandList.getCommand());
		variableName = commandList.getCommand();
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
	}

	@Override
	public double execute(Map<String, Double> variables) {
		variables.put(variableName, getChild(0, variables));
		return variables.get(variableName);
	}

}
