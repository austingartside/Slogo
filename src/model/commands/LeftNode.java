package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class LeftNode extends TurtleCommand{

	public LeftNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}

	@Override
	public double execute(Controller control) {
		double turn = this.executeChild(FIRSTENTRY,control);
		double fake =  control.getTurtle().changeOrientation(MINUS*turn);
		return turn;
	}

}
