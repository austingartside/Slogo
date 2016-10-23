package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;
import model.parser.ProgramParser;

public abstract class ControlCommand extends Command{

	private static String VARIABLE = "Variable";
	private static String STARTLIST = "[";
	private static String ENDLIST = "]";
	private static final String LIST_START_EX = "ListStartException";
	private static final String LIST_END_EX = "ListEndException";
	private static final String NO_VARIABLE_EX = "MissingVariableException";
	
	public ControlCommand(String command) {
		super(command);
	}
	
	public void moveThroughList(ListOfCommands commandList, CommandFactory nodeMaker, Command parent,
			Controller control) throws Exception {
		updateLocation(commandList);
		String currentCommand = commandList.getCommand();
		while(!isEndList(currentCommand)){
			parent.addChild((Command) nodeMaker.getCommand(commandList, control));
			if(commandList.isOutOfBounds()){
				//throw new Exception("no closing bracket");
				control.getExceptionManager().addError(LIST_END_EX);
				break;
			}
			currentCommand = commandList.getCommand();
		}
		updateLocation(commandList);
	}
	
	public void checkForListStart(ListOfCommands commandList, Controller control) throws Exception{
		if(!isStartList(commandList.getCommand())){
			//throw new Exception("Missing front bracket for repeat command");
			control.getExceptionManager().addError(LIST_START_EX);
		}	
	}
	
	public void isVariable(String command, Controller control) throws Exception{
		ProgramParser translator = new ProgramParser();
		String translatedCommand = translator.getSymbol(command);
		if(!translatedCommand.equals(VARIABLE)){
			//throw new Exception("Variable not defined in MakeUserVariable Command");
			control.getExceptionManager().addError(NO_VARIABLE_EX);
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
