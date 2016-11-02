package model;

import java.util.HashMap;
import java.util.Map;
import ViewLogic.DisplayUpdater;
import model.commands.BlankNode;
import model.commands.Command;
import model.exceptions.CommandDoesNotExistException;
import model.parser.ExpressionTreeBuilder;
import screens.MainMenu;

/**
 * @author austingartside
 * 
 */
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
	
	/**
	 * @param command
	 * @return true if a command is executing (false if being defined)
	 */
	public boolean isExecuting(String command){
		return executeCommand.get(command);
	}
	
	/**
	 * @param command
	 * @param count
	 * keeps track of the number of parameters for a command with a given name
	 */
	public void addNumParam(String command, int count){
		numParameters.put(command, count);
	}
	
	public int getNumParam(String command){
		return numParameters.get(command);
	}
	
	/**
	 * @param command
	 * @param value
	 * true if command is executing, false otherwise
	 */
	public void changeExecutingValue(String command, boolean value){
		executeCommand.put(command, value);
	}
	
	/**
	 * @param name
	 * @param value
	 * keep track of user defined variables and their values
	 */
	public void addVariable(String name, double value){
		variables.put(name, value);
	}
	
	public double getVariableValue(String variableName){
		return variables.get(variableName);
	}
	
	/**
	 * @param key
	 * @param value
	 * keep track of user defined commands and their associated nodes
	 */
	public void addCommand(String key, Command value){
		commands.put(key, value);
	}
	
	public Map<String, Command> getCommands(){
	    return commands;
    }
	
	/**
	 * @param command
	 * @throws CommandDoesNotExistException
	 * makes sure that a command exists before using it or adds it if it does not exist
	 */
	public void checkForCommand(String command) throws CommandDoesNotExistException{
	    try{
            if(!commands.containsKey(command)){
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
	
	/**
	 * @return
	 * @throws Exception
	 * Get the expression tree based on the current userInput
	 */
	public Command getTree() throws Exception{
		ExpressionTreeBuilder myExpressionTree=new ExpressionTreeBuilder();
		return (BlankNode) myExpressionTree.makeTree(myController);
	}
	
	public void executeTree(Command head) throws NullPointerException{
		try {
            for (Command currentCommand : head.getChildren()) {
                currentCommand.execute(myController);
                //Thread.sleep(1000);
            }
        }
        catch(NullPointerException n){
        	new DisplayUpdater(MainMenu.slogoScene, null).handleError("Error while executing");
        }
		
	}
}
