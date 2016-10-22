package model.commands;

import java.util.List;
import java.util.Map;

import model.Controller;
import model.Turtle;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class BackwardNode extends TurtleCommand{

	String myVal;
	
	public BackwardNode(String command, ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		myVal = "Backward";
		updateLocation(commandList);	
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
	}
	
	public void printName(){
		System.out.println(myVal);
	}

	@Override
	public double execute(Map<String, Double> variables) {
		//myTurtle.move(MINUS*this.getChild(FIRSTENTRY));
		printName();
		return getChild(FIRSTENTRY, variables);
	}

}
