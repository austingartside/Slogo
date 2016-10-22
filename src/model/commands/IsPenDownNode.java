package model.commands;

import java.util.Map;

import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class IsPenDownNode extends TurtleCommand{

	public IsPenDownNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) {
		super(command);
		updateLocation(commandList);
	}

	@Override
	public double execute(Map<String, Double> variables) {
		return 0;// TODO Auto-generated method stub
		
	}

}
