package commands;

import java.lang.reflect.InvocationTargetException;

public class CommandFactory {
	
	public Object getCommand(String commandName) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		try{
			String className = commandName.substring(0, 1).toUpperCase() + commandName.substring(1) + "Node";
			return Class.forName(className).getConstructor(String.class).newInstance(commandName);
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		throw new IllegalArgumentException("Command " + commandName + " does not exist");	
	}
}
