package model.commands;

import java.util.List;
import java.util.Map;

import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class BlankNode extends TurtleCommand{

	public BlankNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) {
		super(command);
	}

	@Override
	public double execute(Map<String, Double> variables) {
		return 0; // ?????
	}

}
