package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetTowardsNode extends TwoArgumentCommand{

	public SetTowardsNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}

	@Override
	public double execute(Controller control) {
		return control.getTurtleControl().getTurtle().towards(executeChild(FIRSTENTRY, control),executeChild(SECONDENTRY, control) );
	}

}
