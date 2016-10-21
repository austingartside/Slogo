package model.commands.TurtleCommands;

import model.parser.ListOfCommands;

public class HomeNode extends TurtleCommand{

	public HomeNode(String command,ListOfCommands commandList) {
		super(command);
		updateLocation(commandList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
