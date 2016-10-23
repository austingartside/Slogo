package model.commands;

import java.util.Map;

import model.Controller;
import model.commands.LogicCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class NotNode extends LogicCommand{

	public NotNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList));
		this.addChild((Command) nodeMaker.getCommand(commandList));
	}
	@Override
	public double execute(Controller control) {
		double test=this.executeChild(FIRSTENTRY, control);
		// This format has to be used so that the return is a double and not a boolean.
		return test==ZERO ? 1:0;
	}

}