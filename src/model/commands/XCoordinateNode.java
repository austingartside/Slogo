package model.commands;


import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class XCoordinateNode extends NoArgumentCommand{

	public XCoordinateNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
		//commandList.updateLocation();
	}

	@Override
	public double execute(Controller control) {
		return control.getTurtleControl().getTurtle().getNewPositionX();
	}

}
