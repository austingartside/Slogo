package model.commands;

import java.util.Map;

import model.Controller;

public abstract class LogicCommand extends Command {

	public LogicCommand(String command) {
		super(command);
	}

	@Override
	public abstract double execute(Controller control);

}
