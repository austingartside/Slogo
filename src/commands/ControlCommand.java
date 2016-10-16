package commands;

public abstract class ControlCommand extends CommandNode{

	public ControlCommand(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public abstract void execute();

}
