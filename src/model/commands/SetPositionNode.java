package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetPositionNode extends TurtleCommand{

	public SetPositionNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}
	@Override
	public double execute(Controller control) {
		return control.getTurtle().setPosition(this.executeChild(FIRSTENTRY,control),this.executeChild(FIRSTENTRY,control));
		//myTurtle.setPositionY(this.executeChild(SECONDENTRY));
		//return Math.sqrt(Math.pow(control.getTurtle().getNewPositionX()-control.getTurtle().getOldPositionX(), SQUARED)+(Math.pow(control.getTurtle().getNewPositionY()-control.getTurtle().getOldPositionY(),SQUARED)));
		//return ZERO;
	}

}
