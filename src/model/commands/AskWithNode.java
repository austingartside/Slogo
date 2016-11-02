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
		Command conditional = this.getChild(0);
		double lastval=0;
		List<Turtle> TurtleCollection= control.getTurtleControl().getTurtle().getCollection();
		System.out.println("length is " + TurtleCollection.size());
		int temp=TurtleCollection.size();
		for (int i = 0; i<temp;i++){
			Turtle tempTurtle= TurtleCollection.get(0);
			control.getTurtleControl().getTurtle().moveToEnd(tempTurtle);
			double val = conditional.execute(control);
			if(val==1){
				control.getTurtleControl().askListUpdate(tempTurtle.getID());
			}
		}
		control.getTurtleControl().setTurtleArmy();

		for(int j=2;j<this.getNumChildren();j++){
			lastval=this.executeChild(j, control);
		}

		return lastval;
	}

}
