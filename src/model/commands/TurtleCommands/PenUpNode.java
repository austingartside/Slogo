package model.commands.TurtleCommands;

import model.commands.TurtleCommand;
import model.parser.ListOfCommands;

public class PenUpNode extends TurtleCommand{

	public PenUpNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
