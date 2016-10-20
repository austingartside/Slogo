package model.commands;

import model.parser.ListOfCommands;

public abstract class TurtleCommand extends CommandNode {
	
	public TurtleCommand(String command){
		super(command);
	}
	
	public void updateLocation(ListOfCommands commandList) {
		int newCol = commandList.getCol()+1;
		if(newCol>=commandList.getRowLength()){
			newCol = 0;
			commandList.setRow(commandList.getRow()+1);
		}
		commandList.setCol(newCol);
	}
	
	@Override
	public abstract void execute();

}
