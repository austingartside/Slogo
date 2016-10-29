package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ShowTurtleNode extends TurtleCommand{

	public ShowTurtleNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
	}

	@Override
	public double execute(Controller control){
		return control.getTurtle().showTurtle();
	}

}
