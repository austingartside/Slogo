package model.commands;
import java.util.*;

import model.Controller;
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
	public double execute(Controller control) {
		return control.getTurtle().move(this.executeChild(FIRSTENTRY, control));
		//System.out.print("Position:");
		//System.out.println(control.getTurtle().getNewPositionY());
		//printName();
		//return executeChild(FIRSTENTRY, control);
	}
	
	

}
