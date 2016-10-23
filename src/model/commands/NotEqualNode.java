package model.commands;

import java.util.Map;

import model.Controller;
import model.commands.LogicCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class NotEqualNode extends LogicCommand{

	public NotEqualNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
	}
	@Override
	public double execute(Controller control) {
		double expr1=this.executeChild(FIRSTENTRY, control);
		double expr2=this.executeChild(SECONDENTRY, control);
		// This format has to be used so that the return is a double and not a boolean.
		return expr1!=expr2 ? 1:0;
	}

}