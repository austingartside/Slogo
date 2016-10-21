package model.commands.TurtleCommands;

import model.commands.CommandNode;
import model.commands.TurtleCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class RightNode extends TurtleCommand{

	public RightNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		//myTurtle.changeOrientation(this.getChild(FIRSTENTRY));
		return this.getChild(FIRSTENTRY);
	}

}
