package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

/**
 * @author austingartside
 * 
 */

public class MakeVariableNode extends ControlCommand{

	String variableName;
	
	public MakeVariableNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		isVariable(commandList.getCommand(), control);
		if(!control.getCommandController().getVariables().containsKey(commandList.getCommand())){
			control.getCommandController().addVariable(commandList.getCommand(), 0);
		}
		variableName = commandList.getCommand();
		commandList.updateLocation();
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}
	
	public void printName(){
		System.out.println(this.getName());
	}


	@Override
	public double execute(Controller control) {
		printName();
		control.getCommandController().addVariable(variableName, this.executeChild(0, control));
		return control.getCommandController().getVariables().get(variableName);
	}

}
