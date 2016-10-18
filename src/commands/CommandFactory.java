package commands;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CommandFactory {
	
	private static final String PACKAGE_NAME = "commands";
	
	
	//haven't done anything about user created variables
	public Object getCommand(String commandName, ListOfCommands commandList) throws Exception{
		try{
			ProgramParser lang = new ProgramParser();
			String translatedCommand = lang.getSymbol(commandName);
			if(isValidCommand(translatedCommand)){
				String className = PACKAGE_NAME + "."+ translatedCommand + "Node";
				return Class.forName(className).getConstructor(String.class).newInstance(translatedCommand, commandList, this);
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
		return command.equals("NOMATCH");
	}
	
}
