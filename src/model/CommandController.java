package model;

import java.util.HashMap;
import java.util.Map;

import ViewLogic.DisplayUpdater;
import model.commands.Command;
import model.exceptions.CommandDoesNotExistException;
import screens.MainMenu;

public class CommandController {
	
	private Map<String, Double> variables;
	private Map<String, Command> commands;
	private Map<String, Boolean> executeCommand;
	private Map<String, Integer> numParameters;
	private Controller myController;
	
	public CommandController(Controller control){
		variables = new HashMap<String, Double>();
		commands = new HashMap<String, Command>();
		executeCommand = new HashMap<String, Boolean>();
		numParameters = new HashMap<String, Integer>();
		myController = control;
	}
	
	public boolean isExecuting(String command){
		return executeCommand.get(command);
	}
	
	public void addNumParam(String command, int count){
		numParameters.put(command, count);
	}
	
	public int getNumParam(String command){
		return numParameters.get(command);
	}
	
	public void changeExecutingValue(String command, boolean value){
		executeCommand.put(command, value);
	}
	
	public void addVariable(String name, double value){
		variables.put(name, value);
	}
	
	public double getVariableValue(String variableName){
	    if(!variables.containsKey(variableName)){
			//myExceptionManager.addError(NO_VARIABLE);
			//System.out.println("Ya Done Goofed");
		}
		return variables.get(variableName);
	}
	
	public void addCommand(String key, Command value){
		commands.put(key, value);
	}
	
	public Map<String, Command> getCommands(){
	    return commands;
    }
	
	public void checkForCommand(String command) throws CommandDoesNotExistException{
	    try{
            if(!commands.containsKey(command)){
                //control.getTurtle().setErrorState(3);
                throw new CommandDoesNotExistException(command + " has not been defined ");
            }
        }
        catch(CommandDoesNotExistException c){
            new DisplayUpdater(MainMenu.slogoScene, myController).handleError(c.getError());
        }
	}
	
	public Command findCommand(String command){
		return commands.get(command);
	}
	
	public Map<String,Double> getVariables(){
		return variables;
	}
}
