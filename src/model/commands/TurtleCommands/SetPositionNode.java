package model.commands.TurtleCommands;

import java.util.Map;

import model.commands.Command;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetPositionNode extends TurtleCommand{

	public SetPositionNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}
	@Override
	public double execute(Map<String, Double> variables) {
		//myTurtle.setPositionX(this.getChild(FIRSTENTRY));
		//myTurtle.setPositionY(this.getChild(SECONDENTRY));
		//return Math.sqrt(Math.pow(myTurtle.getNewPositionX-myTurtle.getOldPositionX, SQUARED)+Math.pow(Math.pow(myTurtle.getPositionY-myTurtle.getOldPositionY,SQUARED)));
		return ZERO;
	}

}
