package model.commands;

import java.util.HashSet;
import java.util.Set;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class AskWithNode extends AskCommand{

	public AskWithNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}

	@Override
	public double execute(Controller control) {
		//child 0 is the expression, so execute that expression for each turtle i guess?
		double turtleNum = 0;
		Command currentTurtle = this.getChild(0);
		int i = 0;
		control.getTurtleControl().getTurtle().getAngle();
		control.getTurtleControl().setTurtleArmy();
		int commandBeginning = i+1;
		for(int j = commandBeginning; j<this.getNumChildren(); j++){
			this.executeChild(j,control);
		}
		return turtleNum;
	}

}
