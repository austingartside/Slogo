package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetHeadingNode extends TurtleCommand{

	public SetHeadingNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList));
	}

	@Override
	public double execute(Controller control) {
		//myTurtle.setOrientation(this.executeChild(FIRSTENTRY));
		return this.executeChild(FIRSTENTRY, control);
	}

}
