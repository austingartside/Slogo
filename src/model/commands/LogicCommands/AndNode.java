package model.commands.LogicCommands;

import model.commands.CommandNode;
import model.commands.LogicCommands.LogicCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class AndNode extends LogicCommand{

	public AndNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
	}
	@Override
	public double execute() {
		double test1=this.getChild(FIRSTENTRY);
		double test2=this.getChild(SECONDENTRY);
		// This format has to be used so that the return is a double and not a boolean.
		if(test1!=ZERO && test2!=ZERO){return 1;}
		else{return 0;}
	}

}
