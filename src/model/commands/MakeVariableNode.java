package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class MakeVariableNode extends ControlCommand{

	String variableName;
	String myName;
	
	public MakeVariableNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		myName = command;
		updateLocation(commandList);
		isVariable(commandList.getCommand());
		variableName = commandList.getCommand();
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
	}
	
	public void printName(){
		System.out.println(myName);
	}


	@Override
	public double execute(Controller control) {
		printName();
		control.addVariable(variableName, this.executeChild(0, control));
		return control.getVariables().get(variableName);
	}

}
