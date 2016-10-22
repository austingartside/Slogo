package model.commands.MathCommands;

import model.commands.Command;
import model.commands.MathCommands.MathCommand;
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
	public double execute() {
		double expr1=this.getChild(FIRSTENTRY);
		double expr2=this.getChild(SECONDENTRY);
		return expr1/expr2;
	}

}
