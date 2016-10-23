package model;

import model.commands.Command;

public class ModelMain {
	public static void main(String[] args) throws Exception{
		Controller creator = new Controller();
		String userInput = "ifelse 2 [ fd 50 [ bk 100 ]";
		creator.enterAction(userInput);
		//Command head = creator.getTree();
		//creator.executeTree(head);
	}
}
