package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

/**
 * @author austingartside
 * 
 */
public class BlankNode extends TurtleCommand{
	private static final String BLANK = "BlankNode";
	
	public BlankNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(BLANK);
	}

	@Override
	public double execute(Controller control) {
		return 0;
	}

}
