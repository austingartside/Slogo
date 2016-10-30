package model.commands;

import java.util.Map;

import model.Controller;
import model.commands.MathCommand;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ProductNode extends TwoArgumentCommand{

	public ProductNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
//		commandList.updateLocation();
//		this.addChild((Command) nodeMaker.getCommand(commandList, control));
//		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}
	@Override
	public double execute(Controller control) {
		double expr1=executeChild(FIRSTENTRY, control);
		double expr2=executeChild(SECONDENTRY, control);
		return expr1*expr2;
	}

}
