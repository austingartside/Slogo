package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ConstantNode extends TurtleCommand{

	private double myVal;
	
	public ConstantNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(commandList.getCommand());
		myVal = Double.parseDouble(commandList.getCommand());
		updateLocation(commandList);
	}
	
	public void printName(){
		System.out.println(myVal);
	}

	@Override
	public double execute(Controller control) {
		printName();
		return myVal;	
	}

}
