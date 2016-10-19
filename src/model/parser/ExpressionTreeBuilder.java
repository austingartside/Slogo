package model.parser;
import java.util.*;

import model.commands.BlankNode;
import model.commands.CommandFactory;
import model.commands.CommandNode;
import model.commands.TurtleCommand;

public class ExpressionTreeBuilder {
	
	
	/**
	 * @return expression tree based on the typed used input
	 * @throws Exception
	 */
	public CommandNode makeTree() throws Exception{
		InputReader inputControl = new InputReader();
		CommandFactory nodeCreator = new CommandFactory();
		ListOfCommands commandList = new ListOfCommands(inputControl.getInputtedCommands(), 0, 0);
		TurtleCommand head = new BlankNode("blank_node");
		while(commandList.getRow()<commandList.getNumRows())
			if(isValid(commandList.getRowList())){	
				head.addChild((CommandNode)nodeCreator.getCommand(commandList.getCommand(), commandList));
			}
		return head;
	}
	
	private boolean isValid(List<String> line){
		return line.size()>0;
	}

}
