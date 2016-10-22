package model.commands;
import java.util.*;

import model.parser.CommandFactory;
import model.parser.ListOfCommands;
import model.parser.ProgramParser;

public class ForwardNode extends TurtleCommand{
	
	private String myName;
	
	public ForwardNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		myName = "Forward";
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));	
	}
	
	public void printName(){
		System.out.println(myName);
	}

	@Override
	public double execute(Map<String, Double> variables) {
		//myTurtle.move(MINUS*this.getChild(FIRSTENTRY));
		printName();
		return getChild(0, variables);
	}
	
	

}
