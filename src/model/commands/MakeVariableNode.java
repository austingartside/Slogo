package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class MakeVariableNode extends ControlCommand{

	String variableName;
	
	public MakeVariableNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		isVariable(commandList.getCommand(), control);
		variableName = commandList.getCommand();
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}
	
	public void printName(){
		System.out.println(this.getName());
	}


	@Override
	public double execute(Controller control) {
		printName();
		control.addVariable(variableName, this.executeChild(0, control));
		return control.getVariables().get(variableName);
	}

}
