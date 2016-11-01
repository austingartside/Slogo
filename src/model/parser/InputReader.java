package model.parser;

import java.util.ArrayList;
import java.util.List;
/**
 * @author austingartside
 * 
 */
public class InputReader {

	private static final String WHITESPACE = " +";
	private static final char COMMENT = '#';
	private List<List<String>> textInput;
    
	public InputReader(String userInput){
		convertInputToList(userInput);
	}
	
    /**
     * @return The command input separated by whitespace and lines. 
     * Each row is a line in the input and each element is a symbol (could be command or + or etc.)
     */
    public List<List<String>> getInputtedCommands(){
    	return textInput;
    }
    
    /**
     * @param input
     * Take in a string input and put it in a List of Lists (each row is a line in the original input)
     */
    private void convertInputToList(String input){
    	textInput = new ArrayList<List<String>>();
    	String[] lineSeparatedText = input.split("\n");
    	
    	for(String line: lineSeparatedText){
    		line = line.trim().toLowerCase();
    		if(line.length()==0 || line.charAt(0) == COMMENT){
    			textInput.add(new ArrayList<String>());
    		}
			else{
				String[] splitLine = line.split(WHITESPACE);
				List<String> lineInput = convertArrayToList(splitLine);
				textInput.add(lineInput);
			}
    	}
    }
    
    private List<String> convertArrayToList(String[] list){
    	List<String> convertedList = new ArrayList<String>();
    	for(int i = 0; i<list.length; i++){
    		convertedList.add(list[i]);
    	}
    	return convertedList;
    }
}
