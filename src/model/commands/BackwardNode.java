package model.commands;

import java.util.List;
import java.util.Map;

import model.Controller;
import model.Turtle;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class BackwardNode extends TurtleCommand{

	String myVal;
	
	public BackwardNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		myVal = "Backward";
		commandList.updateLocation();	
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}
	
	public void printName(){
		System.out.println(myVal);
	}

	@Override
	public double execute(Controller control) {
		printName();
		double something = this.executeChild(FIRSTENTRY,control);
		double fake = control.getTurtle().move(MINUS*something);
		return something;
	}

}
