package model.commands.MathCommands;

import java.util.Map;

import model.commands.Command;

public abstract class MathCommand extends Command {

	public MathCommand(String command) {
		super(command);
	}

	@Override
	public abstract double execute(Map<String, Double> variables);

}
