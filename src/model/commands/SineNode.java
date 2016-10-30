package model.commands;

import java.util.Map;

import model.Controller;
import model.commands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SineNode extends OneArgumentCommand{

	public SineNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
//		commandList.updateLocation();
//		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}
	@Override
	public double execute(Controller control) {
		return Math.sin(executeChild(FIRSTENTRY, control));
	}

}
