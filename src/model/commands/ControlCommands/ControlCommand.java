package model.commands.ControlCommands;

import model.commands.CommandNode;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;
import model.parser.ProgramParser;

public abstract class ControlCommand extends CommandNode{

	public ControlCommand(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	
	public void moveThroughList(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		updateLocation(commandList);
		String currentCommand = commandList.getCommand();
		while(!isEndList(currentCommand)){
			addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
					commandList));
			if(commandList.isOutOfBounds()){
				throw new Exception("no closing brakcet");
			}
			currentCommand = commandList.getCommand();
		}
		updateLocation(commandList);
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
