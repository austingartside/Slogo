package model.commands;

import model.Controller;
import model.commands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class NaturalLogNode extends MathCommand{

	public NaturalLogNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList));
	}
	@Override
	public double execute(Controller control) {
		return Math.log(executeChild(FIRSTENTRY, control));
		
	}

}