package model.commands;
import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class ForwardNode extends OneArgumentCommand{
	
	public ForwardNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList, nodeMaker, control);
	}
	
	@Override
	public double execute(Controller control) {
		return control.getTurtleControl().getTurtle().move(this.executeChild(FIRSTENTRY, control));
	}

}