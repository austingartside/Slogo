package model.commands.TurtleCommands;

import model.commands.CommandNode;
import model.commands.TurtleCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetPositionNode extends TurtleCommand{

	public SetPositionNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
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
		//myTurtle.setPositionX(this.getChild(FIRSTENTRY));
		//myTurtle.setPositionY(this.getChild(SECONDENTRY));
		//return Math.sqrt(Math.pow(myTurtle.getNewPositionX-myTurtle.getOldPositionX, SQUARED)+Math.pow(Math.pow(myTurtle.getPositionY-myTurtle.getOldPositionY,SQUARED)));
		return ZERO;
	}

}
