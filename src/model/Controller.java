package model;

import javafx.scene.image.ImageView;
import model.parser.ExpressionTreeBuilder;

public class Controller {
	
	private Turtle myTurtle= new Turtle(); // Will have to change for when there are multiple turtles? This statement is here, in case the nodes use the getters and setters.
	
	public void setUp(){
		//Factory useless as of now. May be needed for later additions
		TurtleFactory myTurtleFactory=new TurtleFactory();
		myTurtle= myTurtleFactory.createTurtle();
	}
	//I may have misunderstood how the tree takes in the input.
	public void buildTree(String entry) throws Exception{
		ExpressionTreeBuilder myExpressionTree=new ExpressionTreeBuilder();
		myExpressionTree.makeTree();
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
