package model.commands;

import java.util.Map;

public abstract class LogicCommand extends Command {

	public LogicCommand(String command) {
		super(command);
	}

	@Override
	public abstract double execute(Map<String, Double> variables);

}
