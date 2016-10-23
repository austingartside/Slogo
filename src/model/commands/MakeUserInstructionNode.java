package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;
import model.parser.ProgramParser;

public class MakeUserInstructionNode extends ControlCommand{

	private static final String COMMAND = "Command";
	private String definedCommandName;
	
	public MakeUserInstructionNode(String command, ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(command);
		updateLocation(commandList);
		checkIfCommand(commandList.getCommand());
		definedCommandName = commandList.getCommand();
		Command definedCommand =  (Command) nodeMaker.getCommand(commandList.getCommand(), commandList);
		this.addChild(definedCommand);
		checkForListStart(commandList);
		updateLocation(commandList);
		while(!isEndList(commandList.getCommand())){
			isVariable(commandList.getCommand());
			definedCommand.addChild((Command) nodeMaker.getCommand(commandList.getCommand(), commandList));
			updateLocation(commandList);
		}
		updateLocation(commandList);
		checkForListStart(commandList);
		moveThroughList(commandList, nodeMaker, definedCommand);
	}
	
	private void checkIfCommand(String command) throws Exception{
		ProgramParser translator = new ProgramParser();
		if(!translator.getSymbol(command).equals(COMMAND)){
			throw new Exception();
		}
	}

	@Override
	public double execute(Controller control) {
		Command definedCommand = this.getChildren().get(0);
		control.addCommand(definedCommandName, definedCommand);
		return 1;
	}

}
