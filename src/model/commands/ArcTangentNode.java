package model.commands;

import java.util.Map;

import model.Controller;
import model.commands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ArcTangentNode extends MathCommand{

	public ArcTangentNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
		// TODO Auto-generated constructor stub
	}
	@Override
	public double execute(Controller control) {
		return Math.atan(executeChild(FIRSTENTRY, control));
	}

}