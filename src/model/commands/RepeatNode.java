package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

/**
 * @author austingartside
 * 
 */

public class RepeatNode extends ControlCommand{
	
	private static final String ITER_VALUE = ":repcount";
	
	public RepeatNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
		checkForListStart(commandList, control);
		moveThroughList(commandList, nodeMaker, this, control, this.getName());
	}
	
	@Override
	public double execute(Controller control) {
		double numTimes = executeChild(0, control);
		double lastVal = 0;
		for(double i = 0; i<numTimes; i++){
			control.getCommandController().addVariable(ITER_VALUE, i);
			for(int j = 1; j<this.getNumChildren(); j++){
				 lastVal = executeChild(j, control);
			}
		}
		return lastVal;
	}

}
