package model.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Controller;

/**
 * @author austingartside
 *
 */
public class CommandSaver {
	private List<String> commandsToSave;
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
		commandsToSave = new ArrayList<String>();
		commandsWithBrackets = new HashMap<String, Integer>();
		createCommandMap();
	}
	
	public void createCommandMap(){
		commandsWithBrackets.put(REPEAT, 1);
		commandsWithBrackets.put(DOTIMES, 2);
		commandsWithBrackets.put(IF, 1);
		commandsWithBrackets.put(IFELSE, 2);
		commandsWithBrackets.put(FOR, 2);
		commandsWithBrackets.put(USER_INSTRUCTION, 2);
	}
	
	public void saveCommands(ListOfCommands commandList, ProgramParser translator) throws Exception{
		String fullCommand = "";
		while(commandList.getRow()<commandList.getNumRows()){
			if(translator.getSymbol(commandList.getCommand()).equals(USER_INSTRUCTION)){
				System.out.println("pooop");
				fullCommand+=TO+" ";
				addBody(fullCommand, commandList, translator);
				fullCommand = "";
			}
			commandList.updateLocation();
		}	
	}
	
	public void addBody(String fullCommand, ListOfCommands commandList, ProgramParser translator) throws Exception{
		int count = 0;
		while(count<2){
			commandList.updateLocation();
			fullCommand+=commandList.getCommand()+" ";
			if(commandsWithBrackets.containsKey(translator.getSymbol(commandList.getCommand()))){
				count-=commandsWithBrackets.get(translator.getSymbol(commandList.getCommand()));
			}
			if(commandList.getCommand().equals(END_LIST)){
				count++;
			}
		}
		commandsToSave.add(fullCommand);
	}
	
	public void saveVariables(Controller control){
		for(String variable: control.getVariables().keySet()){
			commandsToSave.add(CREATE_VARIABLE + variable + " " + control.getVariableValue(variable));
		}
	}
	
	public void printCommands(){
		for(int i = 0; i<commandsToSave.size(); i++){
			System.out.println(commandsToSave.get(i));
		}
	}
	
	public void saveToFile(){
		
	}
	
	public static void main(String[] args) throws Exception{
		CommandSaver austin = new CommandSaver();
		String command = "TO square [ ] [ ifelse 4 [ FD :size RT 90 ] [ fd 50 ] ] TO triangle [ :size ] [ REPEAT 3 [ FD :size RT 120 ] ]"
				+ " TO house [ ] [ SET :size 100 square FD :size RT 60 triangle 80 FD :size ]";
		InputReader temp = new InputReader(command);
		ListOfCommands commandList = new ListOfCommands(temp.getInputtedCommands(), 0, 0);
		ProgramParser translator = new ProgramParser();
		austin.saveCommands(commandList, translator);
		austin.printCommands();
	}
}
