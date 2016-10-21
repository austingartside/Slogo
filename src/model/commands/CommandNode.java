package model.commands;

import java.util.*;

import model.parser.ListOfCommands;

public abstract class CommandNode {
	
	public final static int FIRSTENTRY=0;
	public final static int SECONDENTRY=1;
	public final static double ZERO=0;
	
	
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
	
	public double getChild(int i){
		return myChildren.get(i).execute();
	}
	

	

	/**
	 * CarryOut the inputed command
	 * @return 
	 */
	public abstract double execute();
}

