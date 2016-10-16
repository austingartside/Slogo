package commands;

public abstract class LogicCommand extends CommandNode {

	public LogicCommand(String command) {
		super(command);
	}

	@Override
	public abstract void execute();

}
