package model.commands;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Controller;
import model.Turtle;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class AskWithNode extends AskCommand{

	public AskWithNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}

	@Override
	public double execute(Controller control) {
		//child 0 is the expression, so execute that expression for each turtle i guess?
		double turtleNum = 0;
		Command conditional = this.getChild(0);
		int i = 0;
		double lastval=0;
		List<Turtle> TurtleCollection= control.getTurtleControl().getTurtle().getCollection();
		System.out.println("pooooooooop");
		System.out.println("length is " + TurtleCollection.size());
		double temp=TurtleCollection.size();
		for (double k=temp-1; i<temp;i++){
			//System.out.println("id is " + t.getID());
			Turtle tempTurtle= TurtleCollection.get((int) k);
			control.getTurtleControl().getTurtle().moveToEnd(tempTurtle);
			//System.out.println("guhan");
			double val = conditional.execute(control);
			//System.out.println("guhan 1.5");
			if(val==1){
				control.getTurtleControl().askListUpdate(tempTurtle.getID());
				System.out.println("austin sux");
			}
		}
		control.getTurtleControl().setTurtleArmy();
		
		System.out.println("guhan2");

		for(int j=2;j<this.getNumChildren();j++){
			lastval=this.executeChild(j, control);
		}
		System.out.println("guhan3");

		return lastval;
	}

}
