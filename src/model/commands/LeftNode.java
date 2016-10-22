package model.commands;

import model.Controller;
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
	public double execute(Controller control) {
		 return control.getTurtle().changeOrientation(MINUS*this.executeChild(FIRSTENTRY,control));
		// WILL PROBABLY NEED TO CHEKC THIS
	}

}
