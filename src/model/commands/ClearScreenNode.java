package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;


public class ClearScreenNode extends TurtleCommand{

	public ClearScreenNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();	
	}

	@Override
	public double execute(Controller control) {
		//double dist=Math.sqrt(Math.pow(control.getTurtle().getNewPositionX(), SQUARED)+(Math.pow(control.getTurtle().getNewPositionY(),SQUARED)));
		//control.getTurtle().reset();
		//control.getTurtle().setOrientation(ZERO);
		return control.getTurtle().clearScreen();
		////Distance moved by turtle for reset or turtle in general?	
		//return dist;
		////WILL NEED TO CHNAGE TO DIFFER FROM HOME
	}

}
