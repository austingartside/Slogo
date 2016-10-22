package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.ListOfCommands;


public class ClearScreenNode extends TurtleCommand{

	public ClearScreenNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);	
	}

	@Override
	public double execute(Controller control) {
		//double dist=Math.sqrt(Math.pow(myTurtle.getPositionX, SQUARED)+Math.pow(Math.pow(myTurtle.getPositionY,SQUARED)));
		//myTurtle.setPosition(ZERO,ZERO);
		//myTurtle.setOrientation(ZERO);
		////Distance moved by turtle for reset or turtle in general?	
		//return dist;
		////WILL NEED TO CHNAGE TO DIFFER FROM HOME
		return 0; // WILL BE DELETEd
	}

}
