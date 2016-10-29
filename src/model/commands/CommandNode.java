package model.commands;

import java.util.HashMap;
import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class CommandNode extends ControlCommand{

	private String myVarName;

	public CommandNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		myVarName = commandList.getCommand();
		control.checkForCommand(myVarName, control);
		updateLocation(commandList);
		if(!control.isExecuting(myVarName)){
			checkForListStart(commandList, control);
			moveThroughList(commandList, nodeMaker, this, control, myVarName);
		}
		else{
			for(int i = 0; i<control.getNumParam(myVarName); i++){
				this.addChild((Command) nodeMaker.getCommand(commandList, control));
			}
		}
	}


	@Override
	public double execute(Controller control){
		Command commandToExecute = control.findCommand(myVarName);
		Command currentNode = commandToExecute.getChildren().get(0);
		int j = 0;
		Map<String, Double> valBeforeParameter = new HashMap<String, Double>();
		while(!(currentNode instanceof BlankNode)){
			double internalValue = this.executeChild(j, control);
			String varName = ((VariableNode)commandToExecute.getChild(j)).getName();
			valBeforeParameter.put(varName, control.getVariableValue(varName));
			control.addVariable(varName, internalValue);
			j++;
			currentNode = commandToExecute.getChild(j);
		}
		double lastVal = 0;
		for(int i = j+1; i<commandToExecute.getNumChildren(); i++){
			lastVal = commandToExecute.executeChild(i, control);
		}
		for(String key: valBeforeParameter.keySet()){
			control.addVariable(key, valBeforeParameter.get(key));
		}
		return lastVal;
	}

}
