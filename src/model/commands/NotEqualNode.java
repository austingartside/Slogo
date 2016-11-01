package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class NotEqualNode extends TwoArgumentCommand{

	public NotEqualNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}
	@Override
	public double execute(Controller control) {
		double expr1=this.executeChild(FIRSTENTRY, control);
		double expr2=this.executeChild(SECONDENTRY, control);
		// This format has to be used so that the return is a double and not a boolean.
		return expr1!=expr2 ? 1:0;
	}

}