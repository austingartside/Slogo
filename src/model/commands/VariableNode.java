package model.commands;


import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class VariableNode extends TurtleCommand{

	String myVarName;
	
	public VariableNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) {
		super(command);
		myVarName = command;
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}
	
	public String getName(){
		return myVarName;
	}

	@Override
	public double execute(Controller control) {
		return control.getVariableValue(myVarName);
	}

}
