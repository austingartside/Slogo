package commands;

public abstract class TurtleCommand extends CommandNode {
	
	public TurtleCommand(String command){
		super(command);
	}
	
	@Override
	public abstract void execute();

}
