package model;

import model.commands.Command;

public class ModelMain {
	public static void main(String[] args) throws Exception{
		Controller creator = new Controller();
		Command head = creator.getTree();
		creator.executeTree(head);
	}
}
