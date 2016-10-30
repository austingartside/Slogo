package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetPenSizeNode extends OneArgumentCommand{

	public SetPenSizeNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
//		commandList.updateLocation();
//		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}

	@Override
	public double execute(Controller control) {
		double index=this.executeChild(FIRSTENTRY, control);
		control.getDisplaySpecs().setPenSizeIndex(index);
		return index;
	}

}
