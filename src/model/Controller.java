package model;

import java.util.ArrayList;
import java.util.Collection;
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
	private DisplaySpecs myDisplaySpecs;
	//private CommandSaver commandsToSave;
	
	private CommandSaveManager saveManager;
	private CommandController myCommandController;
	private TurtleController myTurtleController;
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
		myDisplaySpecs=new DisplaySpecs(this);
		history = new ArrayList<String>();
		parser = new ProgramParser();
		saveManager = new CommandSaveManager(this);
		myCommandController = new CommandController(this);
		myTurtleController=new TurtleController(this);
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
		myTurtleController.makeTurtle(ONE);
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
		Collection<TurtleView> myTurtleViewCollection=myTurtleController.updateTurtleViewCollection();
		DisplayUpdater myDisplayUpdater= new DisplayUpdater(myActionScene, this);
		myTurtleController.resetClearScreens();
		myDisplayUpdater.updateScreen(myTurtleViewCollection,myDisplaySpecs);
		
	}
	
	public TurtleController getTurtleControl(){
		return myTurtleController;
	}

	public DisplaySpecs getDisplaySpecs() {
		return myDisplaySpecs;
	}

}