package model.commands;


import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

/**
 * @author austingartside
 * 
 */
public class VariableNode extends TurtleCommand{
	
	public VariableNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
	}

	@Override
	public double execute(Controller control) {
		return control.getCommandController().getVariableValue(this.getName());
		//return control.getVariableValue(this.getName());
	}

}
