package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class PenUpNode extends NoArgumentCommand{

	public PenUpNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
		//commandList.updateLocation();
	}

	@Override
	public double execute(Controller control) {
		control.getTurtleControl().getTurtle().penUp();
		return ZERO; 
	}

}
