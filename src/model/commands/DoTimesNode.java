package model.commands;


import model.Controller;
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
		this.addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
		updateLocation(commandList);
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker);
		
	}

	@Override
	public double execute(Controller control) {
		double limit = executeChild(FIRSTENTRY, control);
		double lastVal = 0;
		for(double i = 0; i<limit; i++){
			if(i>=1){
				control.getVariables().put(varName, i);
			}
			for(int j = 1; j<getNumChildren(); j++){
				 lastVal = executeChild(j, control);
			}
		}
		return lastVal;		
	}

}
