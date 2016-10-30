package model.commands;
/**
 * @author austingartside
 * 
 */
import java.util.Random;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class RandomNode extends OneArgumentCommand{
	
	private Random generator;

	public RandomNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
		generator = new Random();
//		commandList.updateLocation();
//		this.addChild((Command) nodeMaker.getCommand(commandList, control));
	}

	@Override
	public double execute(Controller control) {
		double val = this.executeChild(0, control);
		int test= (int) Math.abs(val);
		double answer = 1.0*generator.nextInt(test);
		return answer;
	}

}
