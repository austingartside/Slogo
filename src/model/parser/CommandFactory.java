package model.parser;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import ViewLogic.DisplayUpdater;
import model.Controller;
import model.commands.BlankNode;
import model.commands.ConstantNode;
import model.exceptions.CommandDoesNotExistException;
import screens.MainMenu;

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
		    return null;
			//control.getTurtle().setErrorState(3);
		}
	}
	
//	public boolean isValidCommand(String command){
//		return !command.equals("NO MATCH");
//	}
	
}
