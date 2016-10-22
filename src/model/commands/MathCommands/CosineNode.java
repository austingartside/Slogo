package model.commands.MathCommands;

import java.util.Map;

import model.commands.Command;
import model.commands.MathCommands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class CosineNode extends MathCommand{

	public CosineNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}
	@Override
	public double execute(Map<String, Double> variables) {
		return Math.cos(getChild(FIRSTENTRY, variables));
	}

}
