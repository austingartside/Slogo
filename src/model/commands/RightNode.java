package model.commands;

import java.util.Map;

import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class RightNode extends TurtleCommand{

	public RightNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute(Map<String, Double> variables) {
		//myTurtle.changeOrientation(this.getChild(FIRSTENTRY));
		return this.getChild(FIRSTENTRY, variables);
	}

}
