package model.commands;
/**
 * @author austingartside
 * 
 */
import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class IfElseNode extends ControlCommand{

	private String myName;
	
	public IfElseNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		myName = commandList.getCommand();
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
		checkForListStart(commandList, control);
		BlankNode trueStatements = new BlankNode(commandList, nodeMaker, control);
		BlankNode falseStatements = new BlankNode(commandList, nodeMaker, control);
		this.addChild(trueStatements);
		this.addChild(falseStatements);
		moveThroughList(commandList, nodeMaker, trueStatements, control, myName);
		checkForListStart(commandList, control);
		moveThroughList(commandList, nodeMaker, falseStatements, control, myName);
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
			nodeToUse = this.getChild(1);
		}
		else{
			nodeToUse = this.getChild(2);
		}
		for(int j = 0; j<nodeToUse.getNumChildren(); j++){
			 lastVal = nodeToUse.executeChild(j, control);
		}
		return lastVal;
	}

}
