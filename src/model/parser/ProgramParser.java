package model.parser;

import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import ViewLogic.DisplayUpdater;


public class ProgramParser {
    // "types" and the regular expression patterns that recognize those types
    // note, it is a list because order matters (some patterns may be more generic)
    private List<Entry<String, Pattern>> mySymbols;

    //default language is English
    public ProgramParser () {
        mySymbols = new ArrayList<>();
        addPatterns("resources/languages/English");
        addPatterns("resources/languages/Syntax");
    }

    //Changes the recognized language depending on which language the user picks
    public void changeLanguage(DisplayUpdater updater){
    	mySymbols = new ArrayList<>();
    	addPatterns("resources/languages/" + updater.getLanguage());
    	addPatterns("resources/languages/Syntax");  	
    }
    
    // adds the given resource file to this language's recognized types
    public void addPatterns (String syntax) {
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            mySymbols.add(new SimpleEntry<>(key,
                           // THIS IS THE IMPORTANT LINE
                           Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
    }

    // returns the language's type associated with the given text if one exists 
    public String getSymbol (String text) {
        final String ERROR = "NO MATCH";
        for (Entry<String, Pattern> e : mySymbols) {
            if (match(text, e.getValue())) {
                return e.getKey();
            }
        }
        return ERROR;
    }

    // returns true if the given text matches the given regular expression pattern
    private boolean match (String text, Pattern regex) {
        return regex.matcher(text).matches();
    }
}
