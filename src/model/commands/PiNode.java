package model.commands;

import java.util.Map;

import model.Controller;
import model.commands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class PiNode extends MathCommand{

	public PiNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double execute(Controller control) {
		return Math.PI;
	}

}
