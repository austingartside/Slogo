package model.commands.LogicCommands;

import java.util.Map;

import model.commands.Command;

public abstract class LogicCommand extends Command {

	public LogicCommand(String command) {
		super(command);
	}

	@Override
	public abstract double execute(Map<String, Double> variables);

}
