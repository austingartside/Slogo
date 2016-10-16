package commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
	
	
	final String WHITESPACE = "\\p{Space}";

	//gonna have to make this eventually to check whether or not a command is valid
	private List<String> addedCommands;
	private List<List<String>> textInput;
	
    // utility function that reads given file and returns its entire contents as a single string
    private static String readFileToString (String filename) throws FileNotFoundException {
        final String END_OF_FILE = "\\z";
        Scanner input = new Scanner(new File(filename));
        input.useDelimiter(END_OF_FILE);
        String result = input.next();
        input.close();
        return result;
    }
    
    /**
     * @return The command input separated by whitespace and lines. 
     * Each row is a line in the input and each element is a symbol (could be command or + or etc.)
     */
    public List<List<String>> getInputtedCommands(){
    	return textInput;
    }

    // given some text, prints results of parsing it using the given language
    private void parseText (ProgramParser lang, String[] text) {
    	//textInput = new ArrayList<ArrayList<String>>();
        for (String s : text) {
            if (s.trim().length() > 0 && !s.equals("#")) {
                System.out.println(String.format("%s : %s", s, lang.getSymbol(s)));
            }
        }
        System.out.println();
    }
    
    private void printInput(ProgramParser lang, String text){
    	convertInputToList(text);
    	for(int i = 0; i<textInput.size(); i++){
    		for(int j = 0; j<textInput.get(i).size(); j++){
    			String s = textInput.get(i).get(j);
    			//if(commandExists(lang.getSymbol(s))){
    				System.out.print(String.format("%s:%s    ", s, lang.getSymbol(s)));
    			//}
    		}
    		System.out.println();
    	}
    }
    
//    private boolean commandExists(String command){
//    	return !command.equals("NO MATCH");
//    }
    
    private void convertInputToList(String input){
    	textInput = new ArrayList<List<String>>();
    	String[] lineSeparatedText =input.split("\n");
    	for(String line: lineSeparatedText){
    		line = line.trim().toLowerCase();
    		if(line.length()==0 || line.charAt(0) == '#'){
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
    	
        final String WHITESPACE = "\\p{Space}";
        String[] examples = {
            "",
            "# foo",
            "foo #",
            "#",
            "fd",
            "FD",
            "forwardd",
            "equalp",
            "equal?",
            "equal??",
            "+",
            "SuM",
            "-",
            "*",
            "/",
            "%",
            "~",
            "+not",
            "not+",
            "++",
            "+*+",
            "or",
            "FOR",
            "allOrNothing",
            "all_or_nothing",
            "allOr_nothing?",
            "allOr?nothing_",
            ":allornothing",
            "PI",
            "90",
            "9.09",
            "9.0.0",
            "[",
            "]",
            "(",
            ")"
        };

        ProgramParser lang = new ProgramParser();
        // these are more specific, so add them first to ensure they are checked first
        lang.addPatterns("resources/languages/English");
        lang.addPatterns("resources/languages/Syntax");

        try {
            //String userInput = "fd 50\n rt 90 BACKpoop :distance Left :angle";
        	//String userInput = "make\n set repeat   dotimes\n for\n if\n ifelse\n TO\n";
        	//String userInput = "fd\n bk\n lt\n rt\n SETH\n TOWArDS\n setxy\n goto\n pu\n pd\n st\n ht\n home\n cs\n";
        	//String userInput = "sum\n difference\n product\n QuotienT\n ReMainder\n Minus\n random\n sin\n cos\n tan\n atan\n log\n"
        	//		+ " pow\n pI\n";
        	//String userInput = "less?\n lessp\n Greater?\n greaterP\n equal?\n equalp\n notequal?\n notequalp\n and\n or\n not\n";
            String userInput = "repeat 4 [ fd 50 rt 100 ]\n rt 90 BACK :distance Left :angle";
            //String[] text = userInput.split("\n");
            String fileInput = readFileToString("data/examples/simple/square.logo");
            // try against different inputs
            //parseText(lang, examples);
            //test.parseText(lang, userInput.split(WHITESPACE));
            test.printInput(lang, userInput);
            //parseText(lang, fileInput.split(WHITESPACE));
        }
        catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.err.println(String.format("Could not load pattern file %s", e.getMessage()));
        }
    }

}
