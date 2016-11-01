package model.commands;

import model.Controller;

public abstract class TurtleCommand extends Command {
	
	public TurtleCommand(String command){
		super(command);
	}
	
	@Override
	public abstract double execute(Controller control);

}
