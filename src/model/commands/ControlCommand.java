package model.commands;

import java.util.Map;

import ViewLogic.DisplayUpdater;
import model.Controller;
import model.exceptions.MissingListEndException;
import model.exceptions.MissingListStartException;
import model.exceptions.VariableDoesNotExistException;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;
import model.parser.ProgramParser;
import screens.MainMenu;

public abstract class ControlCommand extends Command{

	private static String VARIABLE = "Variable";
	private static String COMMAND = "Command";
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
//			if(commandList.isOutOfBounds()){
//				//throw new Exception("no closing bracket");
//				control.getExceptionManager().addError(LIST_END_EX);
//				commandList.endParse();
//				System.out.println("move through list broke");
//				//break;
//			}
			try{
				currentCommand = commandList.getCommand();
			}
			catch(IndexOutOfBoundsException e){
				//control.getTurtle().setErrorState(2);
                new DisplayUpdater(MainMenu.displayGenerator, null).handleError("Missing ] at line " + commandList.getRow() + " ");
			}
		}
		
		updateLocation(commandList);
	}
	
	public void checkForListStart(ListOfCommands commandList, Controller control) throws Exception{
		try {
            if (!isStartList(commandList.getCommand())) {
                //throw new Exception("Missing front bracket for repeat command");
                //System.out.println("missing list start?");
                //control.getExceptionManager().addError(LIST_START_EX);
                //control.getTurtle().setErrorState(1);
                throw new MissingListStartException("Missing [ at line " + (commandList.getRow() + 1) + " ");
            }

        }
        catch(MissingListStartException m){
            new DisplayUpdater(MainMenu.displayGenerator, null).handleError(m.getError());
        }
	}
	
//	public void checkVarAsCommand(ListOfCommands commandList) throws VariableDoesNotExistException, Exception{
//		ProgramParser commandTranslator = new ProgramParser();
//		if(commandTranslator.getSymbol(commandList.getCommand()).equals(COMMAND)){
//			throw new VariableDoesNotExistException(commandList.getCommand() + " is not a varaiable, missing colon ");
//		}
//	}
	
	public void isVariable(String command, Controller control) throws VariableDoesNotExistException{
		try {
            ProgramParser translator = new ProgramParser();
            String translatedCommand = translator.getSymbol(command);
            if (!translatedCommand.equals(VARIABLE)) {
                //control.getTurtle().setErrorState(4);
                throw new VariableDoesNotExistException(command + " is not a variable, missing colon ");
            }
        }
        catch(VariableDoesNotExistException v){
            new DisplayUpdater(MainMenu.displayGenerator, null).handleError(v.getError());
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
