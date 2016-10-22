package model.commands;

import java.util.Map;

import model.Controller;
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
	public double execute(Controller control) {
		//myTurtle.setPositionX(this.executeChild(FIRSTENTRY));
		//myTurtle.setPositionY(this.executeChild(SECONDENTRY));
		//return Math.sqrt(Math.pow(myTurtle.getNewPositionX-myTurtle.getOldPositionX, SQUARED)+Math.pow(Math.pow(myTurtle.getPositionY-myTurtle.getOldPositionY,SQUARED)));
		return ZERO;
	}

}
