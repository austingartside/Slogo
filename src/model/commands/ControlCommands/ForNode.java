package model.commands.ControlCommands;

import java.util.Map;

import model.commands.Command;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ForNode extends ControlCommand{

	String variableName;
	
	public ForNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		checkForListStart(commandList);
		updateLocation(commandList);
		isVariable(commandList.getCommand());
		//addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
		variableName = commandList.getCommand();
		moveThroughList(commandList, nodeMaker);
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker);
		
	}

	@Override
	public double execute(Map<String, Double> variables) {
		double varToIncrement = variables.get(variableName);
		double start = getChild(0, variables);
		double end = getChild(1, variables);
		double increment = getChild(2, variables);
		double lastVal = 0;
		for(varToIncrement = start; varToIncrement<end; varToIncrement+=increment){
			lastVal = getChild(3, variables);
			variables.put(variableName, varToIncrement);
		}
		return lastVal;
	}

}
