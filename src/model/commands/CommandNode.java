package model.commands;

import java.util.*;

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

	/**
	 * CarryOut the inputed command
	 */
	public abstract void execute();
}

