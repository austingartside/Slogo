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
	
	public MakeUserInstructionNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		myName = commandList.getCommand();
		updateLocation(commandList);
		checkIfCommand(commandList.getCommand());
		definedCommandName = commandList.getCommand();
		//so that we can check commands during parsing for errors instead of having to wait til execution
		control.addCommand(definedCommandName, new BlankNode(commandList, nodeMaker, control));
		///start check
		checkVariableList(commandList.getRow(), commandList.getCol(), commandList, control);
		//end check
		control.changeExecutingValue(definedCommandName, false);
		Command definedCommand = (Command) nodeMaker.getCommand(commandList, control);
		control.changeExecutingValue(definedCommandName, true);
		this.addChild(definedCommand);
		checkForListStart(commandList, control);
		definedCommand.addChild(new BlankNode(commandList, nodeMaker, control));
		moveThroughList(commandList, nodeMaker, definedCommand, control, myName);
	}
	
	public void checkVariableList(int row, int col, ListOfCommands commandList, Controller control) throws Exception{
		updateLocation(commandList);
		checkForListStart(commandList, control);
		updateLocation(commandList);
		while(!isEndList(commandList.getCommand())){
			isVariable(commandList.getCommand(), control);
			updateLocation(commandList);
		}
		commandList.setRow(row);
		commandList.setCol(col);
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
		return 1;
	}

}
