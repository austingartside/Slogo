package model.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
	
	
	//private static final String WHITESPACE = "\\p{Space}";
	private static final String WHITESPACE = " +";
	//private static final String COMMENT = "Comment";
	private static final char COMMENT = '#';
	
	//for testing
	String userInput = "repeat 4 [ fd 50 rt 100 ]\n rt 90 BACK :distance Left :angle";
	//String userInput = "repeat";
	private List<List<String>> textInput;
    
	public InputReader(){
		convertInputToList(userInput);
		printInput(new ProgramParser());
	}
	
    /**
     * @return The command input separated by whitespace and lines. 
     * Each row is a line in the input and each element is a symbol (could be command or + or etc.)
     */
    public List<List<String>> getInputtedCommands(){
    	return textInput;
    }
    
    private void printInput(ProgramParser lang){
    	//convertInputToList(text);
    	for(int i = 0; i<textInput.size(); i++){
    		for(int j = 0; j<textInput.get(i).size(); j++){
    			String s = textInput.get(i).get(j);
    			//if(commandExists(lang.getSymbol(s))){
    				System.out.print(String.format("%s:%s    ", s, lang.getSymbol(s)));
    			//System.out.print(s + " ");
    			//}
    		}
    		System.out.println();
    	}
    }
    
    private void convertInputToList(String input){
    	ProgramParser myParser = new ProgramParser();
    	textInput = new ArrayList<List<String>>();
    	String[] lineSeparatedText = input.split("\n");
    	
    	for(String line: lineSeparatedText){
    		line = line.trim().toLowerCase();
 
    		//System.out.println(line);
    		//System.out.println(myParser.getSymbol("#"));
    		//System.out.println(myParser.getSymbol(line));
    		//if(line.length()==0 || myParser.getSymbol(line).equals(COMMENT)){
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

    public static void main (String[] args) {
    	
    	InputReader test = new InputReader();

        //ProgramParser lang = new ProgramParser();
        // these are more specific, so add them first to ensure they are checked first
        //lang.addPatterns("resources/languages/English");
        //lang.addPatterns("resources/languages/Syntax");
        
        //String userInput = "repeat 4 [ fd 50 rt 100 ]\n rt 90 BACK :distance Left :angle";

        /*String userInput = "fd 50\n rt 90 BACKpoop :distance Left :angle";
    	String userInput = "make\n set repeat   dotimes\n for\n if\n ifelse\n TO\n";
    	String userInput = "fd\n bk\n lt\n rt\n SETH\n TOWArDS\n setxy\n goto\n pu\n pd\n st\n ht\n home\n cs\n";
    	String userInput = "sum\n difference\n product\n QuotienT\n ReMainder\n Minus\n random\n sin\n cos\n tan\n atan\n log\n"
    			+ " pow\n pI\n";
    	String userInput = "less?\n lessp\n Greater?\n greaterP\n equal?\n equalp\n notequal?\n notequalp\n and\n or\n not\n"
        String[] text = userInput.split("\n");
         try against different inputs
        parseText(lang, examples);
        test.parseText(lang, userInput.split(WHITESPACE));*/
    }

}
