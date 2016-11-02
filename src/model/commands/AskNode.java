package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class AskNode extends AskCommand{

	public AskNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}

	@Override
	public double execute(Controller control) {
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
		control.getTurtleControl().resetArmy();
		return turtleNum;
	}
}