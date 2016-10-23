package model.commands;

import model.Controller;
import model.commands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class DifferenceNode extends MathCommand{

	public DifferenceNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList));
		this.addChild((Command) nodeMaker.getCommand(commandList));
		// TODO Auto-generated constructor stub
	}
	@Override
	public double execute(Controller control) { 
		double expr1=executeChild(FIRSTENTRY, control);
		double expr2=executeChild(SECONDENTRY, control);
		return expr1-expr2;
		
	}

}