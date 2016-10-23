package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class IfElseNode extends ControlCommand{

	private String myName;
	
	public IfElseNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		myName = command;
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		checkForListStart(commandList);
		BlankNode trueStatements = new BlankNode(command, commandList, nodeMaker);
		BlankNode falseStatements = new BlankNode(command, commandList, nodeMaker);
		this.addChild(trueStatements);
		this.addChild(falseStatements);
		moveThroughList(commandList, nodeMaker, trueStatements);
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker, falseStatements);
	}
	
	public void printName(){
		System.out.println(myName);
	}

	@Override
	public double execute(Controller control) {
		printName();
		double checkValue = this.executeChild(0, control);
		double lastVal = 0;
		Command nodeToUse;
		if(checkValue!=0){
			nodeToUse = this.getChildren().get(1);
		}
		else{
			nodeToUse = this.getChildren().get(2);
		}
		for(int j = 0; j<nodeToUse.getNumChildren(); j++){
			 lastVal = nodeToUse.executeChild(j, control);
		}
		return lastVal;
	}

}
