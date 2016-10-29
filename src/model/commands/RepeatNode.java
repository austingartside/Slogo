package model.commands;
/**
 * @author austingartside
 * 
 */
import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class RepeatNode extends ControlCommand{
	
	private static final String ITER_VALUE = ":repcount";
	
	String myVal;
	
	public RepeatNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		myVal = commandList.getCommand();
		commandList.updateLocation();
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
		checkForListStart(commandList, control);
		moveThroughList(commandList, nodeMaker, this, control, myVal);
	}

	public void printVal(){
		System.out.println(myVal);
	}
	
	@Override
	public double execute(Controller control) {
		printVal();
		double numTimes = executeChild(0, control);
		double lastVal = 0;
		for(double i = 0; i<numTimes; i++){
			control.addVariable(ITER_VALUE, i);
			for(int j = 1; j<this.getNumChildren(); j++){
				 lastVal = executeChild(j, control);
			}
		}
		return lastVal;
	}

}
