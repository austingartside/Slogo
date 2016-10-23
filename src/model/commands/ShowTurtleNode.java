package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ShowTurtleNode extends TurtleCommand{

	public ShowTurtleNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
	}

	@Override
	public double execute(Controller control){
		//myTurtle.showTurtle();
		return ZERO;
	}

}
