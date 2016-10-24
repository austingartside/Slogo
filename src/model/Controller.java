package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ViewLogic.DisplayUpdater;
import javafx.scene.image.ImageView;
import model.commands.BlankNode;
import model.commands.Command;
import model.exceptions.CommandDoesNotExistException;
import model.exceptions.VariableDoesNotExistException;
import model.parser.ExpressionTreeBuilder;
import screens.MainMenu;

public class Controller {
	
	private static final String NO_COMMAND = "MissingCommandException";
	private static final String NON_COMMAND = "?aslkn234?3";
	private static final String NO_VARIABLE = "MissingVariableException";
	
	private Map<String, Double> variables;
	private Map<String, Command> commands;
	private Map<String, Boolean> executeCommand;
	private Map<String, Integer> numParameters;
	private List<String> history;
	private String userCommand;
	private ExceptionManager myExceptionManager;
	private Turtle myTurtle; // Will have to change for when there are multiple turtles? This statement is here, in case the nodes use the getters and setters.
	private TurtleView myTurtleView;
	/*private static final Controller INSTANCE=new Controller();
	
	private Controller(){
		if(INSTANCE !=null){
			throw new IllegalStateException("Already instantiated");
		}
	}
	
	public static Controller getInstance(){
		return INSTANCE;
	}*/
	
	public Controller(){
		myTurtle = new Turtle(this);
		variables = new HashMap<String, Double>();
		commands = new HashMap<String, Command>();
		history = new ArrayList<String>();
		myExceptionManager = new ExceptionManager();
		executeCommand = new HashMap<String, Boolean>();
		numParameters = new HashMap<String, Integer>();
	}
	
	public boolean isExecuting(String command){
		return executeCommand.get(command);
	}
	
	public void addNumParam(String command, int count){
		numParameters.put(command, count);
	}
	
	public int getNumParam(String command){
		return numParameters.get(command);
	}
	
	public void changeExecutingValue(String command, boolean value){
		executeCommand.put(command, value);
	}
	
	public void addVariable(String name, double value){
		variables.put(name, value);
	}
	
	public ExceptionManager getExceptionManager(){
		return myExceptionManager;
	}
	
	public String getUserCommand(){
		return userCommand;
	}
	
	public double getVariableValue(String variableName){
		if(!variables.containsKey(variableName)){
			//myExceptionManager.addError(NO_VARIABLE);
			//System.out.println("Ya Done Goofed");
		}
		return variables.get(variableName);
	}
	
	public void addCommand(String key, Command value){
		commands.put(key, value);
	}
	
//	public boolean hasCommand(String command){
//		return commands.containsKey(command);
//	}
	
	public void checkForCommand(String command, Controller control) throws CommandDoesNotExistException{
		if(!commands.containsKey(command)){
			control.getTurtle().setErrorState(3);
			throw new CommandDoesNotExistException(command + " has not been defined ");
		}
	}
	
	public void checkForVariable(String variable, Controller control) throws VariableDoesNotExistException{
		if(!variables.containsKey(variable)){
			control.getTurtle().setErrorState(4);
			throw new VariableDoesNotExistException(variable + " has not been defined ");
		}
	}
	
	public Command findCommand(String command){
		return commands.get(command);
	}
	
	public void setUp(){
		//Factory useless as of now. May be needed for later additions
		TurtleFactory myTurtleFactory=new TurtleFactory();
		myTurtle= myTurtleFactory.createTurtle(this);
		myTurtleView=updateTurtleView();
	}
	//I may have misunderstood how the tree takes in the input.
	public Command getTree() throws Exception{
		ExpressionTreeBuilder myExpressionTree=new ExpressionTreeBuilder();
		return (BlankNode) myExpressionTree.makeTree(this);
	}
	
	public void executeTree(Command head) throws Exception{
		//ExpressionTreeBuilder myExpressionTree=new ExpressionTreeBuilder();
		//BlankNode head = (BlankNode) myExpressionTree.makeTree();
		//System.out.println(head.getChildren().size());
		for(Command currentCommand: head.getChildren()){
			currentCommand.execute(this);
			System.out.println();		
		}
		//System.out.println(myTurtle.getNewPositionX());
		//System.out.println(myTurtle.getNewPositionY());
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
	
	//public void setTurtleModel(Turtle turtle){
		//myTurtle=turtle;
	//}
	
	public TurtleView updateTurtleView(){
		TurtleView turtleView= new TurtleView(myTurtle);
		return turtleView;
	}
	
	public void addHistory(String command){
		history.add(command);
	}
	public List<String> getHistory(){
		return history;
	}

	public void enterAction(String command) throws Exception {
		userCommand = command;
		myExceptionManager.resetErrors();
		Command head=this.getTree();
		//if(myExceptionManager.hasErrors()){
		//	myExceptionManager.printError();
			//give control to the user
			//print the first one
		//}
		//else{
			this.executeTree(head);
			history.add(userCommand);
		//}
	}
	
	public void UpdateView() {
		myTurtleView=updateTurtleView();
		//if (!myTurtle.isPenBoolean()){System.out.print("Grrr");}
		System.out.print("OldXPos:");
		System.out.println(myTurtle.getOldPositionX());
		System.out.print("OldYPos:");
		System.out.println(myTurtle.getOldPositionY());
		System.out.print("NewXPos:");
		System.out.println(myTurtle.getNewPositionX());
		System.out.print("NewYPos:");
		System.out.println(myTurtle.getNewPositionY());
		if(myTurtleView.isClearScreen()){System.out.println("Austin");}
		
		DisplayUpdater myDisplayUpdater= new DisplayUpdater(MainMenu.displayGenerator,this);
		myTurtle.setClearScreenOff();
		myDisplayUpdater.updateScreen(myTurtleView);
	}

}