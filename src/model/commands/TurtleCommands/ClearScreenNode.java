package model.commands.TurtleCommands;

import model.parser.ListOfCommands;

public class ClearScreenNode extends TurtleCommand{

	public ClearScreenNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);	
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
