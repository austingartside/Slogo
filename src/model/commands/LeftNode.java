package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class LeftNode extends OneArgumentCommand{

	public LeftNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}

	@Override
	public double execute(Controller control) {
		double turn = this.executeChild(FIRSTENTRY,control);
		double fake = control.getTurtleControl().getTurtle().changeOrientation(MINUS*turn);
		return turn;
	}

}
