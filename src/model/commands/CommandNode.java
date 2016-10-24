package model.commands;

import java.util.Map;

import model.Controller;
import model.exceptions.CommandDoesNotExistException;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class CommandNode extends ControlCommand{

	private String myVarName;
	private static final String COMMAND = "Command";
	private static final String NO_COMMAND = "MissingCommandException";
	//private static final String BLANK_NODE = "class model.commands.BlankNode";

	public CommandNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		//testing
		myVarName = commandList.getCommand();
		control.checkForCommand(myVarName, control);
		updateLocation(commandList);
		checkForListStart(commandList, control);
		moveThroughList(commandList, nodeMaker, this, control);
	}


	@Override
	public double execute(Controller control){
		//System.out.println(myVarName);
		Command commandToExecute = control.findCommand(myVarName);
		//String varName = ((VariableNode) commandToExecute.getChildren().get(0)).getName();
		//String varName = ((VariableNode) commandToExecute.getChildren().get(0)).getName();
		Command currentNode = commandToExecute.getChildren().get(0);
		int j = 0;
		while(!(currentNode instanceof BlankNode)){
			control.addVariable(((VariableNode)commandToExecute.getChildren().get(j)).getName(),
					this.executeChild(j, control));
			j++;
			currentNode = commandToExecute.getChildren().get(j);
		}
		double lastVal = 0;
		for(int i = j+1; i<commandToExecute.getNumChildren(); i++){
			lastVal = commandToExecute.executeChild(i, control);
		}
		return lastVal;
	}

}
