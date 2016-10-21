package model.commands.TurtleCommands;

import model.commands.CommandNode;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class LeftNode extends TurtleCommand{

	public LeftNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((CommandNode) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		//myTurtle.changeOrientation(MINUS*this.getChild(FIRSTENTRY));
		return this.getChild(FIRSTENTRY);
		// WILL PROBABLY NEED TO CHEKC THIS
	}

}
