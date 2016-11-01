package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ShowTurtleNode extends NoArgumentCommand{

	public ShowTurtleNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}

	@Override
	public double execute(Controller control){
		return control.getTurtleControl().getTurtle().showTurtle();
	}

}
