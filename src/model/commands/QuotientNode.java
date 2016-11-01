package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class QuotientNode extends TwoArgumentCommand{

	public QuotientNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);;
	}
	@Override
	public double execute(Controller control) {
		double expr1=executeChild(FIRSTENTRY, control);
		double expr2=executeChild(SECONDENTRY, control);
		return expr1/expr2;
	}

}
