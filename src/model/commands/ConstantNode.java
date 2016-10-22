package model.commands;

import java.util.Map;

import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ConstantNode extends TurtleCommand{

	private double myVal;
	
	public ConstantNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) {
		super(command);
		myVal = Double.parseDouble(command);
		updateLocation(commandList);
	}
	
	public void printName(){
		System.out.println(myVal);
	}

	@Override
	public double execute(Map<String, Double> variables) {
		printName();
		return myVal;	
	}

}
