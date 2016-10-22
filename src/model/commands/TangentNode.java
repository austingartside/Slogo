package model.commands;

import java.util.Map;

import model.commands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class TangentNode extends MathCommand{

	public TangentNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}
	@Override
	public double execute(Map<String, Double> variables) {
		return Math.tan(getChild(FIRSTENTRY, variables));
	}

}