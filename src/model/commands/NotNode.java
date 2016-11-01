package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class NotNode extends OneArgumentCommand{

	public NotNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}
	@Override
	public double execute(Controller control) {
		double test=this.executeChild(FIRSTENTRY, control);
		// This format has to be used so that the return is a double and not a boolean.
		return test==ZERO ? 1:0;
	}

}