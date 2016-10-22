package model.commands.ControlCommands;

import java.util.Map;

import model.commands.Command;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class DoTimesNode extends ControlCommand{

	String varName;
	
	public DoTimesNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		checkForListStart(commandList);
		updateLocation(commandList);
		isVariable(commandList.getCommand());
		varName = commandList.getCommand();
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
		updateLocation(commandList);
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker);
		
	}

	@Override
	public double execute(Map<String, Double> variables) {
		double limit = getChild(0, variables);
		double lastVal = 0;
		for(double i = 0; i<limit; i++){
			if(i>=1){
				variables.put(varName, i);
			}
			for(int j = 1; j<getNumChildren(); j++){
				 lastVal = getChild(j, variables);
			}
		}
		return lastVal;		
	}

}
