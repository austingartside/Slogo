package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetShapeNode extends OneArgumentCommand{

	public SetShapeNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}
	
	@Override
	public double execute(Controller control) {
		return control.getDisplaySpecs().setShapeIndex(this.executeChild(FIRSTENTRY, control));
	}

}