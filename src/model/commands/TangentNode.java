package model.commands;


import model.Controller;
import model.commands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class TangentNode extends MathCommand{

	public TangentNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList));
	}
	@Override
	public double execute(Controller control) {
		return Math.tan(executeChild(FIRSTENTRY, control));
	}

}