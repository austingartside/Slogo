package model.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author austingartside
 *
 */
public class CommandSaver {
	private List<String> commandsToSave;
	private Map<String, Integer> commandsWithBrackets;
	private static final String TO = "to";
	private static final String END_LIST = "]";
	private static final String REPEAT = "repeat";
	private static final String DOTIMES = "dotimes";
	private static final String IF = "if";
	private static final String IFELSE = "ifelse";
	private static final String FOR = "for";
	
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
		commandsWithBrackets.put(TO, 2);
	}
	
	public void saveCommands(ListOfCommands commandList) throws Exception{
		String fullCommand = "";
		while(commandList.getRow()<commandList.getNumRows()){
			if(commandList.getCommand().toLowerCase().equals(TO)){
				fullCommand+=TO+" ";
				addBody(fullCommand, commandList);
				fullCommand = "";
			}
			commandList.updateLocation();
		}	
	}
	
	public void addBody(String fullCommand, ListOfCommands commandList) throws Exception{
		int count = 0;
		while(count<2){
			commandList.updateLocation();
			fullCommand+=commandList.getCommand()+" ";
			if(commandsWithBrackets.containsKey(commandList.getCommand().toLowerCase())){
				count-=commandsWithBrackets.get(commandList.getCommand());
			}
			if(commandList.getCommand().equals(END_LIST)){
				count++;
			}
		}
		commandsToSave.add(fullCommand);
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
		austin.saveCommands(commandList);
		austin.printCommands();
		
	}
}
