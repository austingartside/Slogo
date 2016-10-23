package model.commands;

import java.util.Map;

import model.Controller;
import model.commands.LogicCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class AndNode extends LogicCommand{

	public AndNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
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
