package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class TellNode extends ControlCommand{

	public TellNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		checkForListStart(commandList, control);
		moveThroughList(commandList, nodeMaker, this, control, this.getName());
	}

	@Override
	public double execute(Controller control) {
		double turtleNum = 0;
		if(this.getNumChildren()>0){
			for(int i = 0; i<this.getNumChildren(); i++){
				turtleNum = this.executeChild(i, control);
				//above line gives you the turtle number so do what you want with that
				//create the turtle if it doesn't exist
			}
		}
		return turtleNum;
	}

}
