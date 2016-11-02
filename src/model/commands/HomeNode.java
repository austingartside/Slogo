package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class HomeNode extends NoArgumentCommand{

	public HomeNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}

	@Override
	public double execute(Controller control) {
		double newPosx= control.getTurtleControl().getTurtle().getNewPositionX();
		double newPosy= control.getTurtleControl().getTurtle().getNewPositionY();
		double dist=Math.sqrt(Math.pow(newPosx, SQUARED)+(Math.pow(newPosy,SQUARED)));
		control.getTurtleControl().getTurtle().reset();
		control.getTurtleControl().getTurtle().setOrientation(ZERO);
		return dist;
		//return 0; //WILL BE DELETED
	}

}
