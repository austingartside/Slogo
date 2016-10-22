package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.ListOfCommands;

public abstract class TurtleCommand extends Command {
	
	public TurtleCommand(String command){
		super(command);
	}
	
	@Override
	public abstract double execute(Controller control);

}
