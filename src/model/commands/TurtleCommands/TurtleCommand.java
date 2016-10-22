package model.commands.TurtleCommands;

import java.util.Map;

import model.commands.Command;
import model.parser.ListOfCommands;

public abstract class TurtleCommand extends Command {
	
	public TurtleCommand(String command){
		super(command);
	}
	
	@Override
	public abstract double execute(Map<String, Double> variables);

}
