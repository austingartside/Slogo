package model.commands;

import java.util.Map;

import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class RepeatNode extends ControlCommand{
	
	private static final String ITER_VALUE = ":repcount";
	
	String myVal;
	
	public RepeatNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		myVal = "Repeat";
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker);
	}

	public void printVal(){
		System.out.println(myVal);
	}
	
	@Override
	public double execute(Map<String, Double> variables) {
		printVal();
		double numTimes = getChild(0, variables);
		double lastVal = 0;
		for(double i = 1; i<numTimes; i++){
			variables.put(ITER_VALUE, i);
			for(int j = 1; j<getNumChildren(); j++){
				 lastVal = getChild(j, variables);
			}
		}
		return lastVal;
	}

}
