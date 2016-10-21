package model.parser;
import java.util.*;

import model.commands.BlankNode;
import model.commands.CommandNode;
import model.commands.TurtleCommands.TurtleCommand;

public class ExpressionTreeBuilder {
	
	
	/**
	 * @return expression tree based on the typed used input
	 * @throws Exception
	 */
	public CommandNode makeTree() throws Exception{
		//ProgramParser lang = new ProgramParser();
		InputReader inputControl = new InputReader();
		CommandFactory nodeCreator = new CommandFactory();
		ListOfCommands commandList = new ListOfCommands(inputControl.getInputtedCommands(), 0, 0);
		TurtleCommand head = new BlankNode("blank_node");
		while(commandList.getRow()<commandList.getNumRows())
			if(isValid(commandList.getRowList())){	
				String myCommand = commandList.getCommand();
				head.addChild((CommandNode)nodeCreator.getCommand(myCommand, commandList));
			}
		return head;
	}
	
	private boolean isValid(List<String> line){
		return line.size()>0;
	}

}
