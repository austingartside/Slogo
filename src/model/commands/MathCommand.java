package model.commands;

import java.util.Map;

public abstract class MathCommand extends Command {

	public MathCommand(String command) {
		super(command);
	}

	@Override
	public abstract double execute(Map<String, Double> variables);

}
