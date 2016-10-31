package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class GetShapeNode extends NoArgumentCommand{

	public GetShapeNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}

	@Override
	public double execute(Controller control) {
		return control.getDisplaySpecs().getShapeIndex();
	}

}
