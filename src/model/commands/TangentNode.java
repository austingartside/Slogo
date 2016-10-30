package model.commands;


import model.Controller;
import model.commands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class TangentNode extends OneArgumentCommand{

	public TangentNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
//		commandList.updateLocation();
//		addChild((Command) nodeMaker.getCommand(commandList, control));
	}
	@Override
	public double execute(Controller control) {
		return Math.tan(executeChild(FIRSTENTRY, control));
	}

}