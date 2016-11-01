package model.commands;

import java.util.HashMap;
import java.util.Map;
import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;
/**
 * @author austingartside
 * 
 */
public class CommandNode extends ControlCommand{

	public CommandNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		String myVarName = this.getName();
		control.getCommandController().checkForCommand(myVarName);
		commandList.updateLocation();
		makeChildren(commandList, nodeMaker, control, myVarName);
	}

	
	/**
	 * Creates the node and it's children. Manner in which it is done depends on whether the command
	 * is being defined or if it's being called
	 */
	private void makeChildren(ListOfCommands commandList, CommandFactory nodeMaker, Controller control,
			String myVarName) throws Exception {
		if(!control.getCommandController().isExecuting(myVarName)){
			checkForListStart(commandList, control);
			moveThroughList(commandList, nodeMaker, this, control, myVarName);
		}
		else{
			for(int i = 0; i<control.getCommandController().getNumParam(myVarName); i++){
				this.addChild((Command) nodeMaker.getCommand(commandList, control));
			}
		}
	}

	@Override
	public double execute(Controller control){
		Command commandToExecute = control.getCommandController().findCommand(this.getName());
		Command currentNode = commandToExecute.getChildren().get(0);
		int j = 0;
		Map<String, Double> valBeforeParameter = new HashMap<String, Double>();
		while(!(currentNode instanceof BlankNode)){
			double internalValue = this.executeChild(j, control);
			String varName = ((VariableNode)commandToExecute.getChild(j)).getName();
			if(control.getCommandController().getVariables().containsKey(varName)){
				valBeforeParameter.put(varName, control.getCommandController().getVariableValue(varName));
			}
			control.getCommandController().addVariable(varName, internalValue);
			j++;
			currentNode = commandToExecute.getChild(j);
		}
		double lastVal = 0;
		for(int i = j+1; i<commandToExecute.getNumChildren(); i++){
			lastVal = commandToExecute.executeChild(i, control);
		}
		for(String key: valBeforeParameter.keySet()){
			control.getCommandController().addVariable(key, valBeforeParameter.get(key));
		}
		return lastVal;
	}

}
