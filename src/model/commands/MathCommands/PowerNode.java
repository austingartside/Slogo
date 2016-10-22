package model.commands.MathCommands;

import java.util.Map;

import model.commands.Command;
import model.commands.MathCommands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class PowerNode extends MathCommand{

	public PowerNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}
	@Override
	public double execute(Map<String, Double> variables) {
		double base=getChild(FIRSTENTRY, variables);
		double exponent=getChild(SECONDENTRY, variables);
		return Math.pow(base,exponent);
	}

}
