package model.commands;

import java.util.*;

import model.Controller;
import model.parser.ListOfCommands;

public abstract class Command {
	
	public final static int FIRSTENTRY=0;
	public final static int SECONDENTRY=1;
	public final static double ZERO=0;
	public final static double MINUS=-1;
	public final static double SQUARED=2;
	public final static double ONE=1;
	
	
	List<Command> myChildren;
	//List<Integer> myChildren;
	String myCommand;
	public Command(String command){
		myCommand = command;
		myChildren = new ArrayList<Command>();
		//myChildren = new ArrayList<Integer>();
	}
	
	public String getName(){
		return myCommand;
	}
	
	public void addChild(Command newChild){
	//public void addChild(){
		myChildren.add(newChild);
		//myChildren.add(1);
	}
	
	public List<Command> getChildren(){
	//public List<Integer> getChildren(){
		return myChildren;
	}
	
	public int getNumChildren(){
		return myChildren.size();
	}
	
	public void updateLocation(ListOfCommands commandList) {
		int newCol = commandList.getCol()+1;
		if(newCol>=commandList.getRowLength()){
			newCol = 0;
			commandList.setRow(commandList.getRow()+1);
			if(commandList.getRow()<commandList.getNumRows()){
				while(commandList.getRowLength()==0){
					commandList.setRow(commandList.getRow()+1);
				}
			}
		}
		commandList.setCol(newCol);
	}
	
	public double executeChild(int i, Controller control){
		return myChildren.get(i).execute(control);
	}

	/**
	 * CarryOut the inputed command
	 * @return 
	 */
	public abstract double execute(Controller control);
}

