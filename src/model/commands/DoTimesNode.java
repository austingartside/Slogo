package model.commands;


import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class DoTimesNode extends ControlCommand{

	private String varName;
	private String myName;
	
	public DoTimesNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		myName = "DoTimes";
		updateLocation(commandList);
		checkForListStart(commandList);
		updateLocation(commandList);
		isVariable(commandList.getCommand());
		varName = commandList.getCommand();
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
		updateLocation(commandList);
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker, this);
		
	}
	
	public void printName(){
		System.out.println(myName);
	}


	@Override
	public double execute(Controller control) {
		printName();
		double limit = this.executeChild(FIRSTENTRY, control);
		double lastVal = 0;
		for(double i = 1; i<=limit; i++){
			if(i>=1){
				control.addVariable(varName, i);
			}
			for(int j = 1; j<this.getNumChildren(); j++){
				 lastVal = this.executeChild(j, control);
			}
		}
		return lastVal;		
	}

}
