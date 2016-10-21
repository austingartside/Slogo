package model.commands;

import java.util.*;

import model.parser.ListOfCommands;

public abstract class CommandNode {
	
	List<CommandNode> myChildren;
	String myCommand;
	public CommandNode(String command){
		myCommand = command;
		myChildren = new ArrayList<CommandNode>();
	}
	
	public String getCommand(){
		return myCommand;
	}
	
	public void addChild(CommandNode newChild){
		myChildren.add(newChild);
	}
	
	public void updateLocation(ListOfCommands commandList) {
		int newCol = commandList.getCol()+1;
		if(newCol>=commandList.getRowLength()){
			newCol = 0;
			commandList.setRow(commandList.getRow()+1);
		}
		commandList.setCol(newCol);
	}

	/**
	 * CarryOut the inputed command
	 */
	public abstract void execute();
}

