package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.image.ImageView;
import model.commands.BlankNode;
import model.commands.Command;
import model.parser.ExpressionTreeBuilder;

public class Controller {
	
	private Map<String, Double> variables;
	private Map<String, Command> commands;
	private List<String> history;
	//Map<String, Integer> variables;
	
	private Turtle myTurtle; // Will have to change for when there are multiple turtles? This statement is here, in case the nodes use the getters and setters.
	
	public Controller(){
		myTurtle = new Turtle();
		variables = new HashMap<String, Double>();
		commands = new HashMap<String, Command>();
		history = new ArrayList<String>();
	}
	
	public void addVariable(String name, double value){
		variables.put(name, value);
	}
	
	public double getVariableValue(String variableName){
		if(!variables.containsKey(variableName)){
			//error?
			System.out.println("Ya Done Goofed");
		}
		return variables.get(variableName);
	}
	
	public void addCommand(String key, Command value){
		commands.put(key, value);
	}
	
	public Command findCommand(String command){
		if(!commands.containsKey(command)){
			//error?
			System.out.println("Ya Done Goofed");
		}
		return commands.get(command);
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
			currentCommand.execute(this);
			System.out.println();		
		}
		System.out.println(myTurtle.getNewPositionX());
		System.out.println(myTurtle.getNewPositionY());
	}	
	
	public Map<String,Double> getVariables(){
		return variables;
	}
//		System.out.println();
//		Command one = head.getChildren().get(0);
//		for(Command currentCommand: one.getChildren()){
//			currentCommand.execute(variables);
//			System.out.println();		
//		}
		
		
		//head.executeChild(0, variables).getName();
	
	//// Im not sure how to get the implemented Turtle executes to affect the Turtle built here. Do we pass in the Turtle as a object or use these getters and setters or another way?
	public Turtle getTurtle(){
		return myTurtle;
	}
	
	public void setTurtleModel(Turtle turtle){
		myTurtle=turtle;
	}
	public ImageView getTurtleView(){
		 return myTurtle.getImage();
	}
	
	public void addHistory(String command){
		history.add(command);
	}
	public List<String> getHistory(){
		return history;
	}

}
