package model.commands;

import java.util.Map;

import model.commands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class QuotientNode extends MathCommand{

	public QuotientNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
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
		double expr1=getChild(FIRSTENTRY, variables);
		double expr2=getChild(SECONDENTRY, variables);
		return expr1/expr2;
	}

}
