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
	
	public ControlCommand(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	
	public void moveThroughList(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		updateLocation(commandList);
		String currentCommand = commandList.getCommand();
		while(!isEndList(currentCommand)){
			this.addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
			if(commandList.isOutOfBounds()){
				throw new Exception("no closing bracket");
			}
			currentCommand = commandList.getCommand();
		}
		updateLocation(commandList);
	}
	
	public void checkForListStart(ListOfCommands commandList) throws Exception{
		if(!isStartList(commandList.getCommand())){
			throw new Exception("Missing front bracket for repeat command");
		}	
	}
	
	public void isVariable(String command) throws Exception{
		ProgramParser translator = new ProgramParser();
		String translatedCommand = translator.getSymbol(command);
		if(!translatedCommand.equals(VARIABLE)){
			throw new Exception("Variable not defined in MakeUserVariable Command");
		}
	}
	
	public boolean isEndList(String command){
//		ProgramParser lang = new ProgramParser();
//		String actualCommand = lang.getSymbol(command);
//		return actualCommand.equals(lang.getSymbol("]"));
		return command.equals(ENDLIST);
	}
	
	private boolean isStartList(String command){
//		ProgramParser lang = new ProgramParser();
//		String actualCommand = lang.getSymbol(command);
//		return actualCommand.equals(lang.getSymbol("]"));
		return command.equals(STARTLIST);
	}
	
	@Override
	public abstract double execute(Controller control);

}
