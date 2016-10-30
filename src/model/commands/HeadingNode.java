package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class HeadingNode extends NoArgumentCommand{

	public HeadingNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
		//commandList.updateLocation();
	}

	@Override
	public double execute(Controller control) {
		return control.getTurtle().getAngle();
		
	}

}
