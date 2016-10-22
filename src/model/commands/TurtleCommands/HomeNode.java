package model.commands.TurtleCommands;

import model.parser.ListOfCommands;

public class HomeNode extends TurtleCommand{

	public HomeNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		//double dist=Math.sqrt(Math.pow(myTurtle.getPositionX, SQUARED)+Math.pow(Math.pow(myTurtle.getPositionY,SQUARED)));
		//myTurtle.setPosition(ZERO,ZERO);
		//myTurtle.setOrientation(ZERO);
		//Distance moved by turtle for reset or turtle in general?	
		//return dist;
		return 0; //WILL BE DELETED
	}

}
