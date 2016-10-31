package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class AskNode extends ControlCommand{

	public AskNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		checkForListStart(commandList, control);
		System.out.print("Bill");
		moveThroughList(commandList, nodeMaker, this, control, this.getName());
		System.out.print("Bill2");
		this.addChild(new BlankNode(commandList, nodeMaker, control));
		System.out.print("Bill2.5");
		checkForListStart(commandList, control);
		System.out.println("Bill3");
		moveThroughList(commandList, nodeMaker, this, control, this.getName());
		System.out.println("Bill 5");
	}

	@Override
	public double execute(Controller control) {
		System.out.println("Bill 6");
		double turtleNum = 0;
		Command currentTurtle = this.getChild(0);
		int i = 0;
		while(!(currentTurtle instanceof BlankNode)){
			System.out.println("Bill 7");
			turtleNum = this.executeChild(i, control);
			System.out.println("Bill boy");
			control.getTurtleControl().askListUpdate(turtleNum);
			System.out.println("Bill girl");
			//somehow store the turtleNum so that you can only execute commands for this turtle
			i++;
			currentTurtle = this.getChild(i);
			System.out.println("Bill ambiguous");
		}
		
		System.out.println("Bill bad");
		control.getTurtleControl().setTurtleArmy();
		System.out.println("Bill 7.5");
		int commandBeginning = i+1;
		for(int j = commandBeginning; j<this.getNumChildren(); j++){
			System.out.println("Bill 8");
			this.executeChild(j,control);
			System.out.println("Bill 9");
			//execute and somehow do it for each turtle, j is the number of which node you want to execute
		}
		return turtleNum;
	}
}
