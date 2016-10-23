package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class IfNode extends ControlCommand{

	public IfNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker, this);
	}

	@Override
	public double execute(Controller control) {
		double checkValue = this.executeChild(0, control);
		double lastVal = 0;
		if(checkValue != 0){
			for(int j = 1; j<getNumChildren(); j++){
				 lastVal = executeChild(j, control);
			}
		}
		return lastVal;
	}

}
