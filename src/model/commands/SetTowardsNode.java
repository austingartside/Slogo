package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetTowardsNode extends TwoArgumentCommand{

	public SetTowardsNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
//		commandList.updateLocation();
//		this.addChild((Command) nodeMaker.getCommand(commandList, control));
//		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}

	@Override
	public double execute(Controller control) {
		return control.getTurtleControl().getTurtle().towards(executeChild(FIRSTENTRY, control),executeChild(SECONDENTRY, control) );
	}

}
