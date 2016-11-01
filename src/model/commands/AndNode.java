package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class AndNode extends TwoArgumentCommand{

	public AndNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}
	@Override
	public double execute(Controller control) {
		double test1=executeChild(FIRSTENTRY, control);
		double test2=executeChild(SECONDENTRY, control);
		// This format has to be used so that the return is a double and not a boolean.
		if(test1!=ZERO && test2!=ZERO){return 1;}
		else{return 0;}
	}

}
