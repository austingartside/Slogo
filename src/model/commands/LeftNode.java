package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class LeftNode extends TurtleCommand{

	public LeftNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList));
	}

	@Override
	public double execute(Controller control) {
		 return control.getTurtle().changeOrientation(MINUS*this.executeChild(FIRSTENTRY,control));
	}

}
