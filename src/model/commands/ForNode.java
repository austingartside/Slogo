package model.commands;

import java.util.Map;

import model.Controller;
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
		//this.addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
		variableName = commandList.getCommand();
		moveThroughList(commandList, nodeMaker, this);
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker, this);		
	}

	@Override
	public double execute(Controller control) {
		double varToIncrement = control.getVariableValue(variableName);
		double start = executeChild(0, control);
		double end = executeChild(1, control);
		double increment = executeChild(2, control);
		double lastVal = 0;
		for(varToIncrement = start; varToIncrement<end; varToIncrement+=increment){
			lastVal = executeChild(3, control);
			control.addVariable(variableName, varToIncrement);
		}
		return lastVal;
	}

}
