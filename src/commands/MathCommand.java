package commands;

public abstract class MathCommand extends CommandNode {

	public MathCommand(String command) {
		super(command);
	}

	@Override
	public abstract void execute();

}
