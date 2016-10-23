package model.commands;

import java.util.List;
import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class BlankNode extends TurtleCommand{
	private static final String BLANK = "BlankNode";
	
	public BlankNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(BLANK);
	}

	@Override
	public double execute(Controller control) {
		return 0;
	}

}
