package model.commands.LogicCommands;

import model.commands.CommandNode;

public abstract class LogicCommand extends CommandNode {

	public LogicCommand(String command) {
		super(command);
	}

	@Override
	public abstract double execute();

}
