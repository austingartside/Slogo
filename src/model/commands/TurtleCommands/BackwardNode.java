package model.commands.TurtleCommands;

import java.util.List;
import java.util.Map;

import model.Controller;
import model.Turtle;
import model.commands.Command;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class BackwardNode extends TurtleCommand{

	public BackwardNode(String command, ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);	
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
	}

	@Override
	public double execute(Map<String, Double> variables) {
		//myTurtle.move(MINUS*this.getChild(FIRSTENTRY));
		return getChild(FIRSTENTRY, variables);
	}

}
