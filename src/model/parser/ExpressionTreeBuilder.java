package model.parser;
import java.util.*;

import model.Controller;
import model.commands.BlankNode;
import model.commands.Command;
import model.commands.TurtleCommand;
/**
 * @author austingartside
 * 
 */
public class ExpressionTreeBuilder {
	
	/**
	 * @return expression tree based on the typed used input
	 * @throws Exception
	 */
	public Command makeTree(Controller control) throws Exception{
		InputReader inputControl = new InputReader(control.getUserCommand());
		ListOfCommands commandList = new ListOfCommands(inputControl.getInputtedCommands(), 0, 0);
		CommandFactory nodeCreator = new CommandFactory();
		Command head = new BlankNode(commandList, nodeCreator, control);
		while(commandList.getRow()<commandList.getNumRows()){
			if(commandList.isValidLine()){	
				head.addChild((Command)nodeCreator.getCommand(commandList, control));
			}
			else{
				commandList.movePastBlankRows();
			}
		}
		return head;
	}

}