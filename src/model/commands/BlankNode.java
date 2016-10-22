package model.commands;

import java.util.List;
import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class BlankNode extends TurtleCommand{

	public BlankNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) {
		super(command);
	}

	@Override
	public double execute(Controller control) {
		return 0; // ?????
	}

}
