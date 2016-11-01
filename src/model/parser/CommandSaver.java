package model.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.CommandSaveManager;
import model.Controller;

/**
 * @author austingartside
 *
 */
public class CommandSaver {
	private Map<String, Integer> commandsWithBrackets;
	private static final String TO = "To";
	private static final String USER_INSTRUCTION = "MakeUserInstruction";
	private static final String END_LIST = "]";
	private static final String REPEAT = "Repeat";
	private static final String DOTIMES = "DoTimes";
	private static final String IF = "If";
	private static final String IFELSE = "Ifelse";
	private static final String FOR = "For";
	private static final String CREATE_VARIABLE = "make ";
	
	public CommandSaver(){
		commandsWithBrackets = new HashMap<String, Integer>();
		createCommandMap();
	}
	
	private void createCommandMap(){
		commandsWithBrackets.put(REPEAT, 1);
		commandsWithBrackets.put(DOTIMES, 2);
		commandsWithBrackets.put(IF, 1);
		commandsWithBrackets.put(IFELSE, 2);
		commandsWithBrackets.put(FOR, 2);
		commandsWithBrackets.put(USER_INSTRUCTION, 2);
	}
	
	/**
	 * @param commandList
	 * @param manager
	 * @throws Exception
	 * Extract text for user defined commands from user input (uses addBody to extract everything after "to")
	 */
	private void saveCommands(ListOfCommands commandList, CommandSaveManager manager) throws Exception{
		String fullCommand = "";
		ProgramParser translator = manager.getParser();
		while(commandList.getRow()<commandList.getNumRows()){
			if(commandList.isValidLine()){
				if(translator.getSymbol(commandList.getCommand()).equals(USER_INSTRUCTION)){
					fullCommand+=TO+" ";
					addBody(fullCommand, commandList, manager);
					fullCommand = "";
				}
			}
			commandList.updateLocation();
		}
	}
	
	private void addBody(String fullCommand, ListOfCommands commandList, CommandSaveManager manager) throws Exception{
		int count = 0;
		boolean isName = true;
		String commandName = "";
		while(count<2){
			commandList.updateLocation();
			if(isName){
				commandName = commandList.getCommand();
				isName = false;
			}
			fullCommand+=commandList.getCommand()+" ";
			if(commandsWithBrackets.containsKey(manager.getParser().getSymbol(commandList.getCommand()))){
				count-=commandsWithBrackets.get(manager.getParser().getSymbol(commandList.getCommand()));
			}
			if(commandList.getCommand().equals(END_LIST)){
				count++;
			}
		}
		manager.addCommandToSave(commandName, fullCommand);
	}
	
	/**
	 * @param control
	 * Create text definition of variable based on variable name and value
	 */
	private void saveVariables(Controller control){
		for(String variable: control.getCommandController().getVariables().keySet()){
			control.getSaveManager().addCommandToSave(variable, CREATE_VARIABLE + variable + " "
			+ control.getCommandController().getVariableValue(variable) + " ");
		}
	}
	
	/**
	 * @param commandList
	 * @param manager
	 * @throws Exception
	 * Call saveCommands and saveVariables to create list of String definitions for variables and user defined commands
	 */
	public void saveAll(ListOfCommands commandList, CommandSaveManager manager) throws Exception{
		commandList.goToStart();
		saveCommands(commandList, manager);
		saveVariables(manager.getController());
	}
	
	/**
	 * @param manager
	 * @param fileName
	 * @throws IOException
	 * save existing user-defined commands and variables to a txt file in your project folder
	 */
	public void saveToFile(CommandSaveManager manager, String fileName) throws IOException{
		FileWriter writer = new FileWriter(fileName+".txt"); 
		for(String command: manager.getCommandsInOrder()) {
			writer.write(manager.getCommandToSave(command));
		}
		writer.close();
	}
	
	/**
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * Load text from saved text file containing saved commands and variables
	 */
	public String readFileToString (File file) throws FileNotFoundException {
        final String END_OF_FILE = "\\z";
        Scanner input = new Scanner(file);
        input.useDelimiter(END_OF_FILE);
        String result = input.next();
        input.close();
        return result;
    }
}
