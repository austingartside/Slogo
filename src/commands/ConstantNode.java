package commands;

public class ConstantNode extends TurtleCommand{

	private double myVal;
	
	public ConstantNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) {
		super(command);
		myVal = Double.parseDouble(command);
		updateLocation(commandList);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub	
	}

}
