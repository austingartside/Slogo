package model.parser;
import ViewLogic.DisplayUpdater;
import model.Controller;
import screens.MainMenu;

/**
 * @author austingartside
 * 
 */

public class CommandFactory {
	
	private static final String PACKAGE_NAME = "commands";
    private static final String SUPER_PACKAGE_NAME="model.";
	
    
	/**
	 * @param commandList
	 * @param control
	 * @return Class of the command that matches the given string translated using the resource file
	 * @throws Exception
	 */
	public Object getCommand(ListOfCommands commandList, Controller control) throws Exception{
		String translatedCommand = control.getParser().getSymbol(commandList.getCommand());
		try{
			String className =SUPER_PACKAGE_NAME + PACKAGE_NAME + "."+ translatedCommand + "Node";
			return Class.forName(className).getConstructor(ListOfCommands.class, CommandFactory.class, Controller.class)
					.newInstance(commandList, this, control);
		} catch(Exception e){
			new DisplayUpdater(MainMenu.slogoScene, null).handleError("Command: " + commandList.getCommand() + " not defined ");
			commandList.updateLocation();
		    return null;
		}
	}
}
