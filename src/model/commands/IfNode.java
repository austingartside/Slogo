package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class IfNode extends ControlCommand{
	
	private String myName;
	
	public IfNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		myName = commandList.getCommand();
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
		checkForListStart(commandList, control);
		moveThroughList(commandList, nodeMaker, this, control);
	}
	
	public void printName(){
		System.out.println(myName);
	}

	@Override
	public double execute(Controller control) {
		printName();
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
