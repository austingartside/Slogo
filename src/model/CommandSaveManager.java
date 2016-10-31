package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.parser.CommandSaver;
import model.parser.InputReader;
import model.parser.ListOfCommands;
import model.parser.ProgramParser;

public class CommandSaveManager {
	
	private Map<String, String> commandToStringDefinition;
	private CommandSaver commandsToSave;
	private List<String> commandsInOrder;
	Controller myController;
	
	public CommandSaveManager(Controller control){
		commandToStringDefinition = new HashMap<String, String>();
		commandsToSave = new CommandSaver();
		commandsInOrder = new ArrayList<String>();
		myController = control;
	}
	
	public void addCommandToSave(String command, String definition){
		commandToStringDefinition.put(command, definition);
		commandsInOrder.add(command);
	}
	
	public List<String> getCommandsInOrder(){
		return commandsInOrder;
	}
	
	public Map<String, String> getCommandsToSave(){
		return commandToStringDefinition;
	}
	
	public String getCommandToSave(String command){
		return commandToStringDefinition.get(command);
	}
	
	public void callSaveFile(String fileName) throws IOException{
	    commandsToSave.saveToFile(this, fileName);
	}
	
	public Controller getController(){
		return myController;
	}
	
	public ProgramParser getParser(){
		return myController.getParser();
	}
	
//	public String readFile(String filename) throws FileNotFoundException{
//		return commandsToSave.readFileToString(filename);
//	}
	
	public String readFile(File file) throws FileNotFoundException{
		return commandsToSave.readFileToString(file);
	}
	
	public void saveCommands() throws Exception{
		InputReader inputControl = new InputReader(myController.getUserCommand());
		ListOfCommands commandList = new ListOfCommands(inputControl.getInputtedCommands(), 0, 0);
		commandsToSave.saveAll(commandList, this);
	}

}
