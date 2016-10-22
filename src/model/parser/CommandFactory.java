package model.parser;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import model.commands.BlankNode;
import model.commands.ConstantNode;

public class CommandFactory {
	
	private static final String PACKAGE_NAME = "commands";
    private static final String SUPER_PACKAGE_NAME="model.";
	
	
	//haven't done anything about user created variables
	public Object getCommand(String commandName, ListOfCommands commandList) throws Exception{
		try{
			ProgramParser lang = new ProgramParser();
			String translatedCommand = lang.getSymbol(commandName);
			//System.out.println(translatedCommand);
			if(isValidCommand(translatedCommand)){
				String className =SUPER_PACKAGE_NAME + PACKAGE_NAME + "."+ translatedCommand + "Node";
				return Class.forName(className).getConstructor(String.class, ListOfCommands.class, CommandFactory.class).newInstance(commandName, commandList, this);
			}
			else{
				throw new IllegalArgumentException("Command " + commandName + " does not exist");
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		throw new IllegalArgumentException("Command " + commandName + " does not exist");	
	}
	
	public boolean isValidCommand(String command){
		return !command.equals("NOMATCH");
	}
	
	public static void main(String[] args) throws Exception{
//		CommandFactory nodeMaker = new CommandFactory();
//		InputReader temp = new InputReader();
//		ListOfCommands commandList = new ListOfCommands(temp.getInputtedCommands(), 0, 0);
		//System.out.println(commandList.getCommand());
		//commandList.setCol(commandList.getCol()+1);
		//System.out.println(commandList.getCommand());
		//BlankNode austin = new BlankNode("thing",commandList, nodeMaker);
		//austin.addChild(new ConstantNode("50", commandList, nodeMaker));
		//System.out.println(austin.getChildren().size());
		//System.out.println(austin.getChildren().get(0));
		//System.out.println(austin.getChildren().get(1));
		//nodeMaker.getCommand(commandList.getCommand(), commandList);
		
	}
	
}
