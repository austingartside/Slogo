package model.commands;

import java.util.Map;

import model.Controller;
import model.commands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class PowerNode extends TwoArgumentCommand{

	public PowerNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
//		commandList.updateLocation();
//		this.addChild((Command) nodeMaker.getCommand(commandList, control));
//		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}
	@Override
	public double execute(Controller control) {
		double base=executeChild(FIRSTENTRY, control);
		double exponent=executeChild(SECONDENTRY, control);
		return Math.pow(base,exponent);
	}

}
