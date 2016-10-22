package model.commands;

import java.util.List;

import model.commands.TurtleCommands.TurtleCommand;

public class BlankNode extends TurtleCommand{

	public BlankNode(String command) {
		super(command);
	}

	@Override
	public double execute() {
		return 0; // ?????
	}

}
