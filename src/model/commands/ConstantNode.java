package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

/**
 * @author austingartside
 * 
 */

public class ConstantNode extends TurtleCommand{

	private double myVal;
	
	public ConstantNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		myVal = Double.parseDouble(commandList.getCommand());
		commandList.updateLocation();
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
