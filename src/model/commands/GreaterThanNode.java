package model.commands;

import model.Controller;
import model.commands.LogicCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class GreaterThanNode extends LogicCommand{

	public GreaterThanNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
	}
	@Override
	public double execute(Controller control) {
		double expr1=this.executeChild(FIRSTENTRY, control);
		double expr2=this.executeChild(SECONDENTRY, control);
		// This format has to be used so that the return is a double and not a boolean.
		if(expr1>expr2){return 1;}
		else{return 0;}
	}

}
