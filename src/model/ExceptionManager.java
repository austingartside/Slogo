package model;

import java.util.HashMap;
import java.util.Map;

public class ExceptionManager {
	private static final String LIST_START = "ListStartException";
	private static final String LIST_START_MESSAGE = "ListStartException: missing start bracket [";
	private static final String LIST_END = "ListENDException";
	private static final String LIST_END_MESSAGE = "ListStartException: missing end bracket ]";
	private static final String NO_COMMAND = "MissingCommandException";
	private static final String NO_COMMAND_MESSAGE = "MissingCommandException: Command does not exist";
	private static final String NO_VARIABLE = "MissingVariableException";
	private static final String NO_VARIABLE_MESSAGE = "MissingVariableException: Variable does not exist";
	
	
	private Map<String, String> exceptions;
	
	public ExceptionManager(){
		exceptions = new HashMap<String, String>();
		exceptions.put(LIST_START, LIST_START_MESSAGE);
		exceptions.put(LIST_END, LIST_END_MESSAGE);
		exceptions.put(NO_COMMAND, NO_COMMAND_MESSAGE);
		exceptions.put(NO_VARIABLE, NO_VARIABLE_MESSAGE);
		
	}

}
