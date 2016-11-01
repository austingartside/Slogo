package model.commands;

import ViewLogic.DisplayUpdater;
import model.Controller;
import model.exceptions.MissingListStartException;
import model.exceptions.VariableDoesNotExistException;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;
import model.parser.ProgramParser;
import screens.MainMenu;

/**
 * @author austingartside
 * 
 */
public abstract class ControlCommand extends Command{

	private static String VARIABLE = "Variable";
	private static String COMMAND = "Command";
	private static String STARTLIST = "[";
	private static String ENDLIST = "]";
	
	public ControlCommand(String command) {
		super(command);
	}
	
	/**
	 * @param commandList
	 * @param nodeMaker
	 * @param parent
	 * @param control
	 * @param originalCommand
	 * @throws Exception
	 * For commands with brackets, goes through the commands in between start and end brackets and adds children
	 * of the given parent. In case of parsing through a command and it's variables, counts the number fo variables
	 */
	public void moveThroughList(ListOfCommands commandList, CommandFactory nodeMaker, Command parent,
			Controller control, String originalCommand) throws Exception {
		ProgramParser translator = control.getParser();
		commandList.updateLocation();
		String currentCommand = commandList.getCommand();
		int count = 0;
		while(!isEndList(currentCommand)){
			parent.addChild((Command) nodeMaker.getCommand(commandList, control));
			count++;
			try{
				currentCommand = commandList.getCommand();
			}
			catch(IndexOutOfBoundsException e){
                new DisplayUpdater(MainMenu.slogoScene, null).handleError("Missing ] at line " + commandList.getRow() + " ");
			}
		}
		if(translator.getSymbol(originalCommand).equals(COMMAND)){
			control.getCommandController().addNumParam(originalCommand, count);
		}
		commandList.updateLocation();
	}
	
	public void checkForListStart(ListOfCommands commandList, Controller control) throws Exception{
		try {
            if (!isStartList(commandList.getCommand())) {
                throw new MissingListStartException("Missing [ at line " + (commandList.getRow() + 1) + " ");
            }

        }
        catch(MissingListStartException m){
            new DisplayUpdater(MainMenu.slogoScene, null).handleError(m.getError());
        }
	}
	
	public void isVariable(String command, Controller control) throws VariableDoesNotExistException{
		try {
            ProgramParser translator = control.getParser();
            String translatedCommand = translator.getSymbol(command);
            if (!translatedCommand.equals(VARIABLE)) {
                throw new VariableDoesNotExistException(command + " is not a variable, missing colon ");
            }
        }
        catch(VariableDoesNotExistException v){
            new DisplayUpdater(MainMenu.slogoScene, null).handleError(v.getError());
        }
	}
	
	public boolean isEndList(String command){
		return command.equals(ENDLIST);
	}
	
	private boolean isStartList(String command){
		return command.equals(STARTLIST);
	}
	
	@Override
	public abstract double execute(Controller control);

}
