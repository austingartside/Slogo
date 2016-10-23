package model.commands;

import java.util.Map;

import model.Controller;
import model.commands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class PowerNode extends MathCommand{

	public PowerNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList));
		this.addChild((Command) nodeMaker.getCommand(commandList));
	}
	@Override
	public double execute(Controller control) {
		double base=executeChild(FIRSTENTRY, control);
		double exponent=executeChild(SECONDENTRY, control);
		return Math.pow(base,exponent);
	}

}
