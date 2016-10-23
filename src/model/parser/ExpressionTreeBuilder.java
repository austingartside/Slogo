package model.parser;
import java.util.*;

import model.Controller;
import model.commands.BlankNode;
import model.commands.Command;
import model.commands.TurtleCommand;

public class ExpressionTreeBuilder {
	
	
	/**
	 * @return expression tree based on the typed used input
	 * @throws Exception
	 */
	public Command makeTree(Controller control) throws Exception{
		//ProgramParser lang = new ProgramParser();
		InputReader inputControl = new InputReader(control.getUserCommand());
		CommandFactory nodeCreator = new CommandFactory();
		ListOfCommands commandList = new ListOfCommands(inputControl.getInputtedCommands(), 0, 0);
		Command head = new BlankNode(commandList, nodeCreator, control);
		while(commandList.getRow()<commandList.getNumRows()){
			if(isValid(commandList.getRowList())){	
				head.addChild((Command)nodeCreator.getCommand(commandList, control));
			}
			else{
				commandList.setRow(commandList.getRow()+1);
			}
		}
		return head;
	}
	
	private boolean isValid(List<String> line){
		return line.size()>0;
	}

}