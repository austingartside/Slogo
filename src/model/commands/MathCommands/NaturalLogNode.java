package model.commands.MathCommands;

import model.commands.Command;
import model.commands.MathCommands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class NaturalLogNode extends MathCommand{

	public NaturalLogNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}
	@Override
	public double execute() {
		return Math.log(this.getChild(FIRSTENTRY));
		
	}

}