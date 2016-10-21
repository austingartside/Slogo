package model.commands.ControlCommands;

import model.commands.CommandNode;
import model.parser.ProgramParser;

public abstract class ControlCommand extends CommandNode{

	public ControlCommand(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isEndList(String command){
//		ProgramParser lang = new ProgramParser();
//		String actualCommand = lang.getSymbol(command);
//		return actualCommand.equals(lang.getSymbol("]"));
		return command.equals("]");
	}
	
	@Override
	public abstract void execute();

}
