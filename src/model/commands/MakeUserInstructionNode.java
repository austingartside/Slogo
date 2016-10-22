package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;
import model.parser.ProgramParser;

public class MakeUserInstructionNode extends ControlCommand{

	private static final String COMMAND = "Command";
	
	public MakeUserInstructionNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		checkIfCommand(commandList.getCommand());
		this.addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
		checkForListStart(commandList);
		updateLocation(commandList);
		while(!isEndList(commandList.getCommand())){
			isVariable(commandList.getCommand());
			this.addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
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
	public double execute(Controller control) {
		
		return 0;
	}

}
