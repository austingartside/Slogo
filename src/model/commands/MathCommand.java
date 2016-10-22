package model.commands;

import java.util.Map;

import model.Controller;

public abstract class MathCommand extends Command {

	public MathCommand(String command) {
		super(command);
	}

	@Override
	public abstract double execute(Controller control);

}
