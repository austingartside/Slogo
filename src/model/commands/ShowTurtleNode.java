package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.ListOfCommands;

public class ShowTurtleNode extends TurtleCommand{

	public ShowTurtleNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute(Controller control){
		//myTurtle.showTurtle();
		return ZERO;
	}

}
