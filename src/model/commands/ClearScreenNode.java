package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;


public class ClearScreenNode extends TurtleCommand{

	public ClearScreenNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);	
	}

	@Override
	public double execute(Controller control) {
		double dist=Math.sqrt(Math.pow(control.getTurtle().getNewPositionX(), SQUARED)+(Math.pow(control.getTurtle().getNewPositionY(),SQUARED)));
		control.getTurtle().setPosition(ZERO,ZERO);
		control.getTurtle().setOrientation(ZERO);
		////Distance moved by turtle for reset or turtle in general?	
		return dist;
		////WILL NEED TO CHNAGE TO DIFFER FROM HOME
	}

}