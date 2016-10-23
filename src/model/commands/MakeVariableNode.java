package model.commands;

import java.util.Map;

import model.Controller;
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
	public double execute(Controller control) {
		control.getVariables().put(variableName, executeChild(0, control));
		return control.getVariables().get(variableName);
	}

}
