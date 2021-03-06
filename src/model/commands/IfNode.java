package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;
/**
 * @author austingartside
 * 
 */

public class IfNode extends ConditionalCommand{
	
	public IfNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
		moveThroughList(commandList, nodeMaker, this, control, this.getName());
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
