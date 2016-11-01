package model.commands;
import java.util.*;

import model.Controller;
import model.parser.ListOfCommands;

/**
 * @author austingartside
 * 
 */

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
	
	public String getName(){
		return myCommand;
	}
	
	public void addChild(Command newChild){
		myChildren.add(newChild);
	}
	
	public Command getChild(int childNum){
		return myChildren.get(childNum);
	}
	
	public List<Command> getChildren(){
		return myChildren;
	}
	
	public int getNumChildren(){
		return myChildren.size();
	}
	
	/**
	 * run execute for a given child
	 * @return value returned by command
	 */
	public double executeChild(int i, Controller control){
		return myChildren.get(i).execute(control);
	}

	/**
	 * CarryOut the inputed command
	 * @return 
	 */
	public abstract double execute(Controller control);
}

