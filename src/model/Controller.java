package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import ViewLogic.DisplayUpdater;
import javafx.stage.Stage;
import model.commands.Command;
import model.parser.ProgramParser;
import screens.SLogoScene;

public class Controller {

    public static final double ONE=1;
	
	private List<String> history;
	private String userCommand;
	private SLogoScene myActionScene;
	private ProgramParser parser;
	private DisplaySpecs myDisplaySpecs;
	
	private CommandSaveManager saveManager;
	private CommandController myCommandController;
	private TurtleController myTurtleController;
	private DisplayUpdater du;
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
		history = new ArrayList<>();
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
		du = new DisplayUpdater(myActionScene,this);
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

	public void enterAction(String command) throws Exception {
		userCommand = command;
		Command head = myCommandController.getTree();
		myCommandController.executeTree(head);
		saveManager.saveCommands();
		history.add(userCommand);
	}
	
	public void updateView() {
		Collection<TurtleView> myTurtleViewCollection=myTurtleController.updateTurtleViewCollection();
		myTurtleController.resetClearScreens();
		du.updateScreen(myTurtleViewCollection,myDisplaySpecs);
	}
	
	public TurtleController getTurtleControl(){
		return myTurtleController;
	}

	public DisplaySpecs getDisplaySpecs() {
		return myDisplaySpecs;
	}
	
	public void doneWithCommand(){
	    du.moveTurtle();
	}

}