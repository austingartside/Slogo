package model.commands;
import java.util.*;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;
import model.parser.ProgramParser;

public class ForwardNode extends OneArgumentCommand{
	
	//private String myName;
	
	public ForwardNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		//super(commandList.getCommand());
		super(commandList, nodeMaker, control);
		//myName = commandList.getCommand();
		//commandList.updateLocation();
		//this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}
	
//	public void printName(){
//		System.out.println(myName);
//	}

	@Override
	public double execute(Controller control) {
		//printName();
		return control.getTurtleControl().getTurtle().move(this.executeChild(FIRSTENTRY, control));
	}

}