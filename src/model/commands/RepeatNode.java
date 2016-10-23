package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class RepeatNode extends ControlCommand{
	
	private static final String ITER_VALUE = ":repcount";
	
	String myVal;
	
	public RepeatNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		myVal = "Repeat";
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker, this);
	}

	public void printVal(){
		System.out.println(myVal);
	}
	
	@Override
	public double execute(Controller control) {
		printVal();
		double numTimes = executeChild(0, control);
		double lastVal = 0;
		for(double i = 1; i<numTimes; i++){
			control.addVariable(ITER_VALUE, i);
			for(int j = 1; j<getNumChildren(); j++){
				 lastVal = executeChild(j, control);
			}
		}
		return lastVal;
	}

}
