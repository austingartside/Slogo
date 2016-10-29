package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import ViewLogic.DisplayUpdater;
import javafx.stage.Stage;
import model.commands.BlankNode;
import model.commands.Command;
import model.exceptions.CommandDoesNotExistException;
import model.parser.ExpressionTreeBuilder;
import screens.MainMenu;
import screens.SLogoScene;

public class Controller {
	
	private static final String NO_COMMAND = "MissingCommandException";
	private static final String NON_COMMAND = "?aslkn234?3";
	private static final String NO_VARIABLE = "MissingVariableException";
	public static final int WIDTH = 1000;
    public static final int HEIGHT  = 600;
    public static final double ONE=1;
	
	private Map<String, Double> variables;
	private SLogoScene myActionScene;
	private Map<String, Command> commands;
	private Map<String, Boolean> executeCommand;
	private Map<String, Integer> numParameters;
	private List<String> history;
	private String userCommand;
	private ExceptionManager myExceptionManager;
	private Collection<Turtle> myTurtleCollection;
	//private Turtle myTurtle; // Will have to change for when there are multiple turtles? This statement is here, in case the nodes use the getters and setters.
	private Collection<TurtleView> myTurtleViewCollection;
	private DisplaySpecs myDisplaySpecs;
	private TurtleFactory myTurtleFactory;
	private TurtleArmy myTurtleArmy;
	private Collection<Double> myTurtleIDs;
	private Collection<Double> myAskList;
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
		myTurtleFactory=new TurtleFactory();
		//myTurtle = new Turtle(this);
		myTurtleIDs=new ArrayList<Double>();
		myTurtleCollection=new ArrayList<Turtle>();
		myTurtleViewCollection=new ArrayList<TurtleView>();
		myAskList=new ArrayList<Double>();
		myDisplaySpecs=new DisplaySpecs();
		variables = new HashMap<>();
		commands = new HashMap<>();
		history = new ArrayList<>();
		myExceptionManager = new ExceptionManager();
		executeCommand = new HashMap<>();
		numParameters = new HashMap<>();
	}
	
	public void setUp(Stage stage,ResourceBundle resources, SLogoScene actionScene){
		//Factory useless as of now. May be needed for later additions
		
		//View set up
		myActionScene=actionScene;
		DisplayUpdater du = new DisplayUpdater(myActionScene,this);
        try {
            du.setUp();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        stage.setScene(myActionScene.getScene());
		
        //Model set Up
		makeTurtle(ONE);
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
	public Map<String, Command> getCommands(){
	    return commands;
    }
	
//	public boolean hasCommand(String command){
//		return commands.containsKey(command);
//	}
	
	public void checkForCommand(String command, Controller control) throws CommandDoesNotExistException{
	    try{
            if(!commands.containsKey(command)){
                //control.getTurtle().setErrorState(3);
                throw new CommandDoesNotExistException(command + " has not been defined ");
            }
        }
        catch(CommandDoesNotExistException c){
            new DisplayUpdater(MainMenu.slogoScene, control).handleError(c.getError());
        }
	}
	
	public Command findCommand(String command){
		return commands.get(command);
	}
	
	//I may have misunderstood how the tree takes in the input.
	public Command getTree() throws Exception{
		ExpressionTreeBuilder myExpressionTree=new ExpressionTreeBuilder();
		return (BlankNode) myExpressionTree.makeTree(this);
	}
	
	public void executeTree(Command head) throws NullPointerException{
		//ExpressionTreeBuilder myExpressionTree=new ExpressionTreeBuilder();
		//BlankNode head = (BlankNode) myExpressionTree.makeTree();
		//System.out.println(head.getChildren().size());
		try {
            for (Command currentCommand : head.getChildren()) {
                currentCommand.execute(this);
                System.out.println();
            }
        }
        catch(NullPointerException n){
            new DisplayUpdater(MainMenu.slogoScene, null).handleError("Error parsing command");
        }
		//System.out.println(myTurtle.getNewPositionX());
		//System.out.println(myTurtle.getNewPositionY());
	}	
	
	public Map<String,Double> getVariables(){
		return variables;
	}
	
	//// Im not sure how to get the implemented Turtle executes to affect the Turtle built here. Do we pass in the Turtle as a object or use these getters and setters or another way?
	public TurtleArmy getTurtle(){
		return myTurtleArmy;
	}
	
	public Collection<TurtleView> updateTurtleViewCollection(){
		//Change to binding
		myTurtleViewCollection.clear();
		for(Turtle t: myTurtleCollection){
			TurtleView turtleView= new TurtleView(t);
			myTurtleViewCollection.add(turtleView);
		}
		return myTurtleViewCollection;
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
		myTurtleViewCollection=updateTurtleViewCollection();
		DisplayUpdater myDisplayUpdater= new DisplayUpdater(myActionScene, this);
		resetClearScreens();
		myDisplayUpdater.updateScreen(myTurtleViewCollection,myDisplaySpecs);
		
	}

	private void resetClearScreens() {
		for(Turtle t: myTurtleCollection){
			t.setClearScreenOff();
		}
	}

	public DisplaySpecs getDisplaySpecs() {
		return myDisplaySpecs;
	}

	public void makeTurtle(double turtleNum) {
		Turtle turtle=myTurtleFactory.createTurtle(this, turtleNum);
		myTurtleCollection.add(turtle);
		myTurtleIDs.add(turtleNum);
		myTurtleArmy= new TurtleArmy(myTurtleCollection);
		myTurtleViewCollection=updateTurtleViewCollection();
	}

	public Collection<Turtle> getTurtleList() {
		return myTurtleCollection;
	}
	
	public Collection<Double> getTurtleIDs() {
		return myTurtleIDs;
	}
	
	public void askListUpdate(double turtleNum){
		myAskList.add(turtleNum);
	}
	
	public void setTurtleArmy(){
		Collection<Turtle> tempCollection=new ArrayList<Turtle>();
		
		Iterator<Double> tempIterator= myAskList.iterator();
    	while(tempIterator.hasNext()){
    		Double i=tempIterator.next();
			for(Turtle t :myTurtleCollection){
				if(t.checkID(i)){
					tempCollection.add(t);
				}
			}
		}
    	myTurtleArmy=new TurtleArmy(tempCollection);
		myAskList.clear();
	}
		

}