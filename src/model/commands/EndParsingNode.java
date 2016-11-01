package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

/**
 * @author austingartside
 * 
 */

public class EndParsingNode extends Command{

	public EndParsingNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.endParse();
	}

	@Override
	public double execute(Controller control) {
		return 0;
	}

}
