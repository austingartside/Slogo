package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetPositionNode extends TurtleCommand{

	public SetPositionNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}
	@Override
	public double execute(Controller control) {
		//myTurtle.setPositionX(this.executeChild(FIRSTENTRY));
		//myTurtle.setPositionY(this.executeChild(SECONDENTRY));
		//return Math.sqrt(Math.pow(myTurtle.getNewPositionX-myTurtle.getOldPositionX, SQUARED)+Math.pow(Math.pow(myTurtle.getPositionY-myTurtle.getOldPositionY,SQUARED)));
		return ZERO;
	}

}
