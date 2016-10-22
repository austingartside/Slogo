package model.commands.TurtleCommands;

import java.util.Map;

import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class IsShowingNode extends TurtleCommand{

	public IsShowingNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) {
		super(command);
		updateLocation(commandList);
	}

	@Override
	public double execute(Map<String, Double> variables) {
		
		return 0;// TODO Auto-generated method stub
		
	}

}
