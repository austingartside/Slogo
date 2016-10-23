package model.commands;

import java.util.Map;

import model.Controller;
import model.commands.LogicCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class AndNode extends LogicCommand{

	public AndNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		updateLocation(commandList);
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}
	@Override
	public double execute(Controller control) {
		double test1=executeChild(FIRSTENTRY, control);
		double test2=executeChild(SECONDENTRY, control);
		// This format has to be used so that the return is a double and not a boolean.
		if(test1!=ZERO && test2!=ZERO){return 1;}
		else{return 0;}
	}

}
