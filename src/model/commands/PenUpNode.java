package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class PenUpNode extends NoArgumentCommand{

	public PenUpNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}

	@Override
	public double execute(Controller control) {
		control.getTurtleControl().getTurtle().penUp();
		return ZERO; 
	}

}
