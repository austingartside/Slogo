package model.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javafx.scene.shape.Path;
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
	
	//private void saveCommands(ListOfCommands commandList, Controller control) throws Exception{
	private void saveCommands(ListOfCommands commandList, CommandSaveManager manager) throws Exception{
		String fullCommand = "";
		//ProgramParser translator = control.getParser();
		ProgramParser translator = manager.getParser();
		while(commandList.getRow()<commandList.getNumRows()){
			if(commandList.isValidLine()){
				if(translator.getSymbol(commandList.getCommand()).equals(USER_INSTRUCTION)){
					fullCommand+=TO+" ";
					//addBody(fullCommand, commandList, control);
					addBody(fullCommand, commandList, manager);
					fullCommand = "";
				}
			}
			commandList.updateLocation();
		}
	}
	
	//private void addBody(String fullCommand, ListOfCommands commandList, Controller control) throws Exception{
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
			//if(commandsWithBrackets.containsKey(control.getParser().getSymbol(commandList.getCommand()))){
			//	count-=commandsWithBrackets.get(control.getParser().getSymbol(commandList.getCommand()));
			if(commandsWithBrackets.containsKey(manager.getParser().getSymbol(commandList.getCommand()))){
				count-=commandsWithBrackets.get(manager.getParser().getSymbol(commandList.getCommand()));
			}
			if(commandList.getCommand().equals(END_LIST)){
				count++;
			}
		}
		//control.addCommandToSave(commandName, fullCommand);
		manager.addCommandToSave(commandName, fullCommand);
	}
	
	private void saveVariables(Controller control){
		for(String variable: control.getCommandController().getVariables().keySet()){
		//for(String variable: control..getVariables().keySet()){
			//control.addCommandToSave(variable, CREATE_VARIABLE + variable + " " + control.getVariableValue(variable) + " ");
			//control.getSaveManager().addCommandToSave(variable, CREATE_VARIABLE + variable + " " + control.getVariableValue(variable) + " ");
			control.getSaveManager().addCommandToSave(variable, CREATE_VARIABLE + variable + " "
			+ control.getCommandController().getVariableValue(variable) + " ");
		}
	}
	
	//public void saveAll(ListOfCommands commandList, Controller control) throws Exception{
	public void saveAll(ListOfCommands commandList, CommandSaveManager manager) throws Exception{
		commandList.goToStart();
		//saveCommands(commandList, control);
		saveCommands(commandList, manager);
		//saveVariables(control);
		saveVariables(manager.getController());
	}
	
	//public void saveToFile(Controller control, String fileName) throws IOException{
	public void saveToFile(CommandSaveManager manager, String fileName) throws IOException{
		FileWriter writer = new FileWriter(fileName+".txt"); 
		//for(String command: control.getCommandsInOrder()) {
		for(String command: manager.getCommandsInOrder()) {
		  //writer.write(control.getCommandToSave(command));
			writer.write(manager.getCommandToSave(command));
		}
		writer.close();
	}
	
	//can change String fileName t0 just be a file
    //public String readFileToString (String filename) throws FileNotFoundException {
	public String readFileToString (File file) throws FileNotFoundException {
        final String END_OF_FILE = "\\z";
        Scanner input = new Scanner(file);
        input.useDelimiter(END_OF_FILE);
        String result = input.next();
        input.close();
        return result;
    }
	
//	public static void main(String[] args) throws Exception{
//		CommandSaver austin = new CommandSaver();
//		Controller control = new Controller();
//		control.addVariable(":size", 100);
//		control.addVariable(":poop", 50);
//		String command = "TO square [ ] [ ifelse 4 [ FD :size RT 90 ] [ fd 50 ] ] TO triangle [ :size ] [ REPEAT 3 [ FD :size RT 120 ] ]"
//				+ " TO house [ ] [ SET :size 100 square FD :size RT 60 triangle 80 FD :size ]";
//		InputReader temp = new InputReader(command);
//		ListOfCommands commandList = new ListOfCommands(temp.getInputtedCommands(), 0, 0);
//		austin.saveCommands(commandList, control);
//		austin.saveVariables(control);
//		//austin.printCommands();
//		austin.saveToFile(control);
//	}
}
