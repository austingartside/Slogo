package model.commands;

import java.util.*;

import model.parser.ListOfCommands;

public abstract class Command {
	
	public final static int FIRSTENTRY=0;
	public final static int SECONDENTRY=1;
	public final static double ZERO=0;
	public final static double MINUS=-1;
	public final static double SQUARED=2;
	public final static double ONE=1;
	
	
	List<Command> myChildren;
	String myCommand;
	public Command(String command){
		myCommand = command;
		myChildren = new ArrayList<Command>();
	}
	
	public String getCommand(){
		return myCommand;
	}
	
	public void addChild(Command newChild){
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

