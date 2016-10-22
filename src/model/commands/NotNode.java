package model.commands;

import java.util.Map;

import model.commands.LogicCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class NotNode extends LogicCommand{

	public NotNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
	}
	@Override
	public double execute(Map<String, Double> variables) {
		double test=this.getChild(FIRSTENTRY, variables);
		// This format has to be used so that the return is a double and not a boolean.
		return test==ZERO ? 1:0;
	}

}