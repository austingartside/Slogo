package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class BackwardNode extends OneArgumentCommand{

	String myVal;
	
	public BackwardNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}
	
	@Override
	public double execute(Controller control) {
		double something = this.executeChild(FIRSTENTRY,control);
		double pseudoVar = control.getTurtleControl().getTurtle().move(MINUS*something);
		return something;
	}

}
