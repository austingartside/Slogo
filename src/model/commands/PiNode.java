package model.commands;

import java.util.Map;

import model.Controller;
import model.commands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class PiNode extends NoArgumentCommand{

	public PiNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
		//commandList.updateLocation();
	}
	@Override
	public double execute(Controller control) {
		return Math.PI;
	}

}
