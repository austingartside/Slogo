package model.commands;

import java.util.List;

import model.parser.CommandFactory;

public class BackwardNode extends TurtleCommand{

	public BackwardNode(String command, List<List<String>> commandList, int row, int col, CommandFactory nodeMaker) {
		super(command);
	}

	@Override
	public void execute() {
		
	}

}
