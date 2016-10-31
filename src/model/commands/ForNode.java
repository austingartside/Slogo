package model.commands;
/**
 * @author austingartside
 * 
 */
import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ForNode extends ControlCommand{

	private String variableName;
	
	public ForNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		checkForListStart(commandList, control);
		commandList.updateLocation();
		isVariable(commandList.getCommand(), control);
		variableName = commandList.getCommand();
		//control.addVariable(variableName, 0);
		control.getCommandController().addVariable(variableName, 0);
		//this.addChild((Command) nodeMaker.getCommand(commandList, control));
		moveThroughList(commandList, nodeMaker, this, control, this.getName());
		checkForListStart(commandList, control);
		moveThroughList(commandList, nodeMaker, this, control, this.getName());		
	}

	@Override
	public double execute(Controller control) {
		double start = executeChild(0, control);
		double end = executeChild(1, control);
		double increment = executeChild(2, control);
		double lastVal = 0;
		for(double varToIncrement = start; varToIncrement<end; varToIncrement+=increment){
			for(int i = 3; i<this.getNumChildren(); i++){
				lastVal = executeChild(i, control);
			}
			//control.addVariable(variableName, varToIncrement);
			control.getCommandController().addVariable(variableName, varToIncrement);
		}
		return lastVal;
	}

}
