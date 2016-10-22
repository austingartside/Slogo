package model.commands.TurtleCommands;

import java.util.Map;

import model.commands.Command;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class LeftNode extends TurtleCommand{

	public LeftNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute(Map<String, Double> variables) {
		//myTurtle.changeOrientation(MINUS*this.getChild(FIRSTENTRY));
		return this.getChild(FIRSTENTRY, variables);
		// WILL PROBABLY NEED TO CHEKC THIS
	}

}
