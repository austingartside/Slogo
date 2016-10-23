package model.commands;


import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class VariableNode extends TurtleCommand{
	
	public VariableNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
	}

	@Override
	public double execute(Controller control) {
		System.out.println(this.getName() +" "+ control.getVariableValue(this.getName()));
		return control.getVariableValue(this.getName());
	}

}