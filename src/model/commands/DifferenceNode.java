package model.commands;

import model.Controller;
import model.commands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class DifferenceNode extends MathCommand{

	public DifferenceNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}
	@Override
	public double execute(Controller control) { 
		double expr1=executeChild(FIRSTENTRY, control);
		double expr2=executeChild(SECONDENTRY, control);
		return expr1-expr2;
		
	}

}