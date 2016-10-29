package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class HomeNode extends TurtleCommand{

	public HomeNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute(Controller control) {
		double dist=Math.sqrt(Math.pow(control.getTurtle().getNewPositionX(), SQUARED)+(Math.pow(control.getTurtle().getNewPositionY(),SQUARED)));
		control.getTurtle().reset();
		control.getTurtle().setOrientation(ZERO);
		//Distance moved by turtle for reset or turtle in general?	
		return dist;
		//return 0; //WILL BE DELETED
	}

}
