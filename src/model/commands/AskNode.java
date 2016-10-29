package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class AskNode extends ControlCommand{

	public AskNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		checkForListStart(commandList, control);
		moveThroughList(commandList, nodeMaker, this, control, this.getName());
		this.addChild(new BlankNode(commandList, nodeMaker, control));
		checkForListStart(commandList, control);
		moveThroughList(commandList, nodeMaker, this, control, this.getName());
	}

	@Override
	public double execute(Controller control) {
		double turtleNum = 0;
		Command currentTurtle = this.getChild(0);
		int i = 0;
		while(!(currentTurtle instanceof BlankNode)){
			turtleNum = this.executeChild(i, control);
			//somehow store the turtleNum so that you can only execute commands for this turtle
			i++;
			currentTurtle = this.getChild(i);
		}
		int commandBeginning = i+1;
		for(int j = commandBeginning; j<this.getNumChildren(); j++){
			//execute and somehow do it for each turtle, j is the number of which node you want to execute
		}
		return turtleNum;
	}
}