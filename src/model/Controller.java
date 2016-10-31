package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import ViewLogic.DisplayUpdater;
import javafx.stage.Stage;
import model.commands.BlankNode;
import model.commands.Command;
import model.parser.ExpressionTreeBuilder;
import model.parser.ProgramParser;
import screens.MainMenu;
import screens.SLogoScene;

public class Controller {

	public static final int WIDTH = 1000;
    public static final int HEIGHT  = 600;
    public static final double ONE=1;
	
	private List<String> history;
	private String userCommand;
	private SLogoScene myActionScene;
	private ProgramParser parser;
	private Collection<Turtle> myTurtleCollection;
	//private Turtle myTurtle; // Will have to change for when there are multiple turtles? This statement is here, in case the nodes use the getters and setters.
	private Collection<TurtleView> myTurtleViewCollection;
	private DisplaySpecs myDisplaySpecs;
	private TurtleFactory myTurtleFactory;
	private TurtleArmy myTurtleArmy;
	private Collection<Double> myTurtleIDs;
	private Collection<Double> myAskList;
	//private CommandSaver commandsToSave;
	
	private CommandSaveManager saveManager;
	private CommandController myCommandController;
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
		history = new ArrayList<String>();
		parser = new ProgramParser();
		saveManager = new CommandSaveManager(this);
		myCommandController = new CommandController(this);
	}
	
	public ProgramParser getParser(){
		return parser;
	}
	
	public CommandSaveManager getSaveManager(){
		return saveManager;
	}
	
	public CommandController getCommandController(){
		return myCommandController;
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
	
	public String getUserCommand(){
		return userCommand;
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
		Command head=this.getTree();
		this.executeTree(head);
		saveManager.saveCommands();
		history.add(userCommand);
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