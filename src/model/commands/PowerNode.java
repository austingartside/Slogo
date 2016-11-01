package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class PowerNode extends TwoArgumentCommand{

	public PowerNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}
	@Override
	public double execute(Controller control) {
		double base=executeChild(FIRSTENTRY, control);
		double exponent=executeChild(SECONDENTRY, control);
		return Math.pow(base,exponent);
	}

}
