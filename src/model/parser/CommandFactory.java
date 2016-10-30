package model.parser;
/**
 * @author austingartside
 * 
 */
import ViewLogic.DisplayUpdater;
import model.Controller;
import screens.MainMenu;

public class CommandFactory {
	
	private static final String PACKAGE_NAME = "commands";
    private static final String SUPER_PACKAGE_NAME="model.";
	
	public Object getCommand(ListOfCommands commandList, Controller control) throws Exception{
		String translatedCommand = control.getParser().getSymbol(commandList.getCommand());
		String className;
		try{
			className =SUPER_PACKAGE_NAME + PACKAGE_NAME + "."+ translatedCommand + "Node";
			return Class.forName(className).getConstructor(ListOfCommands.class, CommandFactory.class, Controller.class)
					.newInstance(commandList, this, control);
		} catch(Exception e){
			new DisplayUpdater(MainMenu.slogoScene, null).handleError("Command: " + commandList.getCommand() + " not defined ");
			commandList.updateLocation();
		    return null;
		}
	}
	
}
