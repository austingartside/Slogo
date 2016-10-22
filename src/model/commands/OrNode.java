package model.commands;


import model.Controller;
import model.commands.LogicCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class OrNode extends LogicCommand{

	public OrNode(String command,ListOfCommands commandList,CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(),
				commandList));
	}
	@Override
	public double execute(Controller control) {
		double test1=this.executeChild(FIRSTENTRY, control);
		double test2=this.executeChild(SECONDENTRY, control);
		// This format has to be used so that the return is a double and not a boolean.
		return !(test1 == ZERO && test2 == ZERO) ? 1:0;
//		if(test1!=ZERO || test2!=ZERO){return 1;}
//		else{return 0;}
	}

}
