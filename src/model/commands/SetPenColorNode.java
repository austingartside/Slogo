package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetPenColorNode extends OneArgumentCommand{

	public SetPenColorNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}

	@Override
	public double execute(Controller control) {
		double index=this.executeChild(FIRSTENTRY, control);
		control.getDisplaySpecs().setPenColorIndex(index);
		return index;
	}

}