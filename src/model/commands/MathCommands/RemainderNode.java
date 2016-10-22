package model.commands.MathCommands;

import model.commands.CommandNode;
import model.commands.MathCommands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class RemainderNode extends MathCommand{

	public RemainderNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}
	@Override
	public double execute() {
		double expr1=this.getChild(FIRSTENTRY);
		double expr2=this.getChild(SECONDENTRY);
		return expr1%expr2; ////Its 3 am i just made this up
	}

}
