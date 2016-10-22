package model.commands;

import model.parser.ListOfCommands;

public abstract class TurtleCommand extends Command {
	
	public TurtleCommand(String command){
		super(command);
	}
	
	@Override
	public abstract double execute();

}
