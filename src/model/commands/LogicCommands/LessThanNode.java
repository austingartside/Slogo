package model.commands.LogicCommands;

import model.commands.CommandNode;
import model.commands.LogicCommands.LogicCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class LessThanNode extends LogicCommand{

	public LessThanNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}
	@Override
	public double execute() {
		double expr1=this.getChild(FIRSTENTRY);
		double expr2=this.getChild(SECONDENTRY);
		// This format has to be used so that the return is a double and not a boolean.
		return expr1<expr2 ? 1:0;
	}

}
