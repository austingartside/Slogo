package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.image.ImageView;
import model.commands.BlankNode;
import model.commands.Command;
import model.parser.ExpressionTreeBuilder;

public class Controller {
	
	private Map<String, Double> variables;
	//Map<String, Integer> variables;
	
	private Turtle myTurtle; // Will have to change for when there are multiple turtles? This statement is here, in case the nodes use the getters and setters.
	
	public Controller(){
		myTurtle = new Turtle();
		variables = new HashMap<String, Double>();
	}
	
	public void addVariable(String name, double value){
		variables.put(name, value);
	}
	
	public void setUp(){
		//Factory useless as of now. May be needed for later additions
		TurtleFactory myTurtleFactory=new TurtleFactory();
		myTurtle= myTurtleFactory.createTurtle();
	}
	//I may have misunderstood how the tree takes in the input.
	public void executeTree() throws Exception{
		ExpressionTreeBuilder myExpressionTree=new ExpressionTreeBuilder();
		BlankNode head = (BlankNode) myExpressionTree.makeTree();
		//System.out.println(head.getChildren().size());
		for(Command currentCommand: head.getChildren()){
			currentCommand.execute(variables);
			System.out.println();		
		}
//		System.out.println();
//		Command one = head.getChildren().get(0);
//		for(Command currentCommand: one.getChildren()){
//			currentCommand.execute(variables);
//			System.out.println();		
//		}
		
		
		//head.getChild(0, variables).getName();
		
		
	}
	
	//// Im not sure how to get the implemented Turtle executes to affect the Turtle built here. Do we pass in the Turtle as a object or use these getters and setters or another way?
	public Turtle getTurtleModel(){
		return myTurtle;
	}
	
	public void setTurtleModel(Turtle turtle){
		myTurtle=turtle;
	}
	public ImageView getTurtleView(){
		 return myTurtle.getImage();
	}
	
	public void addHistory(){
		
	}
	public void getHistory(){
		
	}

}
