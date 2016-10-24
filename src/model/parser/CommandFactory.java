package model.parser;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import model.Controller;
import model.commands.BlankNode;
import model.commands.ConstantNode;
import model.exceptions.CommandDoesNotExistException;

public class CommandFactory {
	
	private static final String PACKAGE_NAME = "commands";
    private static final String SUPER_PACKAGE_NAME="model.";
    private static final String NO_COMMAND_EX = "MissingCommandException";
    private static final String END_PARSE = "EndParsingNode";
	
	public Object getCommand(ListOfCommands commandList, Controller control) throws Exception{
		ProgramParser lang = new ProgramParser();
		String translatedCommand = lang.getSymbol(commandList.getCommand());
		String className;
		try{
			className =SUPER_PACKAGE_NAME + PACKAGE_NAME + "."+ translatedCommand + "Node";
			return Class.forName(className).getConstructor(ListOfCommands.class, CommandFactory.class, Controller.class)
					.newInstance(commandList, this, control);
		} catch(Exception e){
			control.getTurtle().setErrorState(3);
			throw new CommandDoesNotExistException(commandList.getCommand() + " does not exist ");
		}	
	}
	
//	public boolean isValidCommand(String command){
//		return !command.equals("NO MATCH");
//	}
	
}
