package commands;

import java.lang.reflect.InvocationTargetException;

public class CommandFactory {
	
	private static final String PACKAGE_NAME = "commands";
	
	public Object getCommand(String commandName) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		try{
			String className = PACKAGE_NAME + "."+ commandName + "Node";
			return Class.forName(className).getConstructor(String.class).newInstance(commandName);
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		throw new IllegalArgumentException("Command " + commandName + " does not exist");	
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		CommandFactory austin = new CommandFactory();
		austin.getCommand("Forward");
	}
	
}
