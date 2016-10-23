package model.commands;

import java.util.Map;
import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;
import model.parser.ProgramParser;

public class MakeUserInstructionNode extends ControlCommand{

	private static final String COMMAND = "Command";
	private String definedCommandName;
	private String myName;
	
	public MakeUserInstructionNode(ListOfCommands commandList, CommandFactory nodeMaker) throws Exception {
		super(commandList.getCommand());
		myName = commandList.getCommand();
		updateLocation(commandList);
		checkIfCommand(commandList.getCommand());
		definedCommandName = commandList.getCommand();
		Command definedCommand = (Command) nodeMaker.getCommand(commandList);
		this.addChild(definedCommand);
		checkForListStart(commandList);
		definedCommand.addChild(new BlankNode(commandList, nodeMaker));
		moveThroughList(commandList, nodeMaker, definedCommand);
	}
	
	public void printName(){
		System.out.println(myName);
	}

	
	private void checkIfCommand(String command) throws Exception{
		ProgramParser translator = new ProgramParser();
		if(!translator.getSymbol(command).equals(COMMAND)){
			throw new Exception();
		}
	}

	@Override
	public double execute(Controller control) {
		printName();
		Command definedCommand = this.getChildren().get(0);
		control.addCommand(definedCommandName, definedCommand);
		//System.out.println(definedCommandName);
		//VariableNode test = (VariableNode)control.findCommand(definedCommandName).getChildren().get(1);
		//int test = control.findCommand(definedCommandName).getChildren().get(4).getChildren().get(0).getNumChildren();
		//System.out.println(test);
		return 1;
	}

}
