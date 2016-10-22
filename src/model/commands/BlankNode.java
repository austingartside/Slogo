package model.commands;

import java.util.List;
import java.util.Map;

import model.commands.TurtleCommands.TurtleCommand;

public class BlankNode extends TurtleCommand{

	public BlankNode(String command) {
		super(command);
	}

	@Override
	public double execute(Map<String, Double> variables) {
		return 0; // ?????
	}

}
