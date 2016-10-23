package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class RightNode extends TurtleCommand{

	public RightNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList));
	}

	@Override
	public double execute(Controller control) {
		return control.getTurtle().changeOrientation(this.executeChild(FIRSTENTRY,control));
	}

}
