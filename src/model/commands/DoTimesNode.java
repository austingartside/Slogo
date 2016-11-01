package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

/**
 * @author austingartside
 * 
 */

public class DoTimesNode extends ControlCommand{

	private String varName;
	
	public DoTimesNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		checkForListStart(commandList, control);
		commandList.updateLocation();
		isVariable(commandList.getCommand(), control);
		varName = commandList.getCommand();
		commandList.updateLocation();
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
		commandList.updateLocation();
		checkForListStart(commandList, control);
		moveThroughList(commandList, nodeMaker, this, control, this.getName());
		
	}
	
	@Override
	public double execute(Controller control) {
		double limit = this.executeChild(FIRSTENTRY, control);
		double lastVal = 0;
		for(double i = 1; i<=limit; i++){
			if(i>=1){
				control.getCommandController().addVariable(varName, i);
			}
			for(int j = 1; j<this.getNumChildren(); j++){
				 lastVal = this.executeChild(j, control);
			}
		}
		return lastVal;		
	}

}
