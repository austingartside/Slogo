package model.commands;

import java.util.HashSet;
import java.util.Set;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class AskWithNode extends ControlCommand{

	public AskWithNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
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
		//child 0 is the expression, so execute that expression for each turtle i guess?
		double turtleNum = 0;
		Command currentTurtle = this.getChild(0);
		int i = 0;
		while(!(currentTurtle instanceof BlankNode)){
			turtleNum = this.executeChild(i, control);
			control.getTurtleControl().askListUpdate(turtleNum);
			i++;
			currentTurtle = this.getChild(i);
		}
		control.getTurtleControl().setTurtleArmy();
		int commandBeginning = i+1;
		for(int j = commandBeginning; j<this.getNumChildren(); j++){
			this.executeChild(j,control);
		}
		return turtleNum;
	}

}
