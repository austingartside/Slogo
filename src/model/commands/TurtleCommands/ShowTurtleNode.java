package model.commands.TurtleCommands;

import java.util.Map;

import model.parser.ListOfCommands;

public class ShowTurtleNode extends TurtleCommand{

	public ShowTurtleNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute(Map<String, Double> variables){
		//myTurtle.showTurtle();
		return ZERO;
	}

}
