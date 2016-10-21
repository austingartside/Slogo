package model.commands.MathCommands;

import model.commands.CommandNode;

public abstract class MathCommand extends CommandNode {

	public MathCommand(String command) {
		super(command);
	}

	@Override
	public abstract void execute();

}
