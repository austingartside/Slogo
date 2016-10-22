package model.commands.TurtleCommands;

import java.util.Map;
import model.commands.TurtleCommand;
import model.parser.ListOfCommands;


public class ClearScreenNode extends TurtleCommand{

	public ClearScreenNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);	
	}

	@Override
	public double execute(Map<String, Double> variables) {
		//double dist=Math.sqrt(Math.pow(myTurtle.getPositionX, SQUARED)+Math.pow(Math.pow(myTurtle.getPositionY,SQUARED)));
		//myTurtle.setPosition(ZERO,ZERO);
		//myTurtle.setOrientation(ZERO);
		////Distance moved by turtle for reset or turtle in general?	
		//return dist;
		////WILL NEED TO CHNAGE TO DIFFER FROM HOME
		return 0; // WILL BE DELETEd
	}

}
