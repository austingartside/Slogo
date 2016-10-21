package model.commands.TurtleCommands;

import model.commands.CommandNode;
import model.parser.ListOfCommands;

public abstract class TurtleCommand extends CommandNode {
	
	public TurtleCommand(String command){
		super(command);
	}
	
	@Override
	public abstract void execute();

}
