package model.commands.TurtleCommands;

import model.commands.TurtleCommand;
import model.parser.ListOfCommands;

public class PenDownNode extends TurtleCommand{

	public PenDownNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
