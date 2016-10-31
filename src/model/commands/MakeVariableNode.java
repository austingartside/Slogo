package model.commands;
/**
 * @author austingartside
 * 
 */
import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class MakeVariableNode extends ControlCommand{

	String variableName;
	
	public MakeVariableNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		isVariable(commandList.getCommand(), control);
		//control.addVariable(commandList.getCommand(), 0);
		control.getCommandController().addVariable(commandList.getCommand(), 0);
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
//		control.addVariable(variableName, this.executeChild(0, control));
//		return control.getVariables().get(variableName);
		control.getCommandController().addVariable(variableName, this.executeChild(0, control));
		return control.getCommandController().getVariables().get(variableName);
	}

}
