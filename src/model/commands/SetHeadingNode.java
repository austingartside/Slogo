package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetHeadingNode extends OneArgumentCommand{

	public SetHeadingNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
//		commandList.updateLocation();
//		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}

	@Override
	public double execute(Controller control) {
		//double val=this.executeChild(FIRSTENTRY, control);
		//return control.getTurtle().setOrientation(val);
		return control.getTurtle().setOrientation(this.executeChild(FIRSTENTRY, control));
		//return val;
	}

}
