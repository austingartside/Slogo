package model.commands.TurtleCommands;

import model.commands.Command;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetHeadingNode extends TurtleCommand{

	public SetHeadingNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		//myTurtle.setOrientation(this.getChild(FIRSTENTRY));
		return this.getChild(FIRSTENTRY);
	}

}
