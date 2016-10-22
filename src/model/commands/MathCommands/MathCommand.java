package model.commands.MathCommands;

import model.commands.Command;

public abstract class MathCommand extends Command {

	public MathCommand(String command) {
		super(command);
	}

	@Override
	public abstract double execute();

}
