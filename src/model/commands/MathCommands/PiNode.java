package model.commands.MathCommands;

import model.commands.CommandNode;
import model.commands.MathCommands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class PiNode extends MathCommand{

	public PiNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double execute() {
		return Math.PI;
	}

}
