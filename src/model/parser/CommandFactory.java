package model.parser;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import model.Controller;
import model.commands.BlankNode;
import model.commands.ConstantNode;

public class CommandFactory {
	
	private static final String PACKAGE_NAME = "commands";
    private static final String SUPER_PACKAGE_NAME="model.";
    private static final String NO_COMMAND_EX = "MissingCommandException";
    private static final String END_PARSE = "EndParsingNode";
	
	public Object getCommand(ListOfCommands commandList, Controller control) throws Exception{
		//try{
			ProgramParser lang = new ProgramParser();
			String translatedCommand = lang.getSymbol(commandList.getCommand());
			String className;
			if(isValidCommand(translatedCommand)){
				className =SUPER_PACKAGE_NAME + PACKAGE_NAME + "."+ translatedCommand + "Node";
			}
			else{
				control.getExceptionManager().addError(NO_COMMAND_EX);
				className = SUPER_PACKAGE_NAME + PACKAGE_NAME + "." + END_PARSE;
			}
			return Class.forName(className).getConstructor(ListOfCommands.class, CommandFactory.class, Controller.class)
					.newInstance(commandList, this, control);
		//}
//		catch(IllegalArgumentException e){
//			e.printStackTrace();
//		}
		//throw new IllegalArgumentException("Command " + commandList.getCommand() + " does not exist");	
	}
	
	public boolean isValidCommand(String command){
		return !command.equals("NOMATCH");
	}
	
}
