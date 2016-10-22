package model.commands.TurtleCommands;

import model.commands.Command;
import model.parser.ListOfCommands;

public abstract class TurtleCommand extends Command {
	
	public TurtleCommand(String command){
		super(command);
	}
	
	@Override
	public abstract double execute();

}
