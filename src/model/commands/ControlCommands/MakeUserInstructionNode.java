package model.commands.ControlCommands;

import model.commands.Command;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;
import model.parser.ProgramParser;

public class MakeUserInstructionNode extends ControlCommand{

	private static final String COMMAND = "Command";
	
	public MakeUserInstructionNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		checkIfCommand(commandList.getCommand());
		addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
		checkForListStart(commandList);
		updateLocation(commandList);
		while(!isEndList(commandList.getCommand())){
			isVariable(commandList.getCommand());
			addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
			updateLocation(commandList);
		}
		updateLocation(commandList);
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker);
	}
	
	private void checkIfCommand(String command) throws Exception{
		ProgramParser translator = new ProgramParser();
		if(translator.getSymbol(command).equals(COMMAND)){
			throw new Exception();
		}
	}

	@Override
	public double execute() {
		return 0;
		// TODO Auto-generated method stub
		
	}

}
