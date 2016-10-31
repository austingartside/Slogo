package ViewLogic;

import View.TurtleDisplay;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.Controller;
import model.DisplaySpecs;
import model.Turtle;
import model.TurtleView;
import model.commands.Command;
import screens.MainMenu;
import screens.SLogoScene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.scene.*;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class DisplayUpdater implements ViewToModelInterface{
    private SLogoScene scene;

    private Controller myController;
    private String loadedFile;
    
    public DisplayUpdater(SLogoScene s, Controller control){
        scene = s;
        loadedFile = "";
        myController = control;
        if(!(scene.getWorkspaceParser() == null)){
            workspaceSetup();
        }
    }
    
    private void workspaceSetup(){
        scene.getTurtleDisplay().changeBackgroundColor(scene.getWorkspaceParser().getBackgroundColor());
        scene.getTurtleDisplay().setPenColor(scene.getWorkspaceParser().getPenColor());
        scene.getTurtleDisplay().getTurtleImage().changeTurtleImage(scene.getWorkspaceParser().getImage());
        scene.getHelpTools().getDisplayOptions().setColors(scene.getWorkspaceParser().getColorList());
        scene.getHelpTools().getDisplayOptions().setImages(scene.getWorkspaceParser().getImageList());
        scene.getSettingTools().getLanguageChooser().setLanguage(scene.getWorkspaceParser().getLanguage());
        loadFile(scene.getWorkspaceParser().getFiletoLoad());
    }
    
    public void setUp() throws Exception{
        addHandlers();
        addTextHandler();
    }

    public void setText(String str){
        scene.getCommandBar().setText(str);
    }
    public void setCoordinate(double penDown, double xPrev, double yPrev, double x, double y){
        scene.getTurtleDisplay().getTurtleImage().drawTurtle(x, y);
        if(penDown==1){
            scene.getTurtleDisplay().drawLine(xPrev, yPrev, x, y);
        }
    }
    public String getLanguage(){
        return scene.getSettingTools().getLanguageChooser().getSelectedItem();
    }
    public void updateHistory(String string){
        scene.getHelpTabs().getCommHist().addItem(string);
    }
    public void updateCurrCommands(String string){
        scene.getHelpTabs().getCurrComm().addItem(string);
    }
    public void updateCurrVariables(String string){
        scene.getHelpTabs().getCurrVar().addItem(string);
    }
    public void updateCurrState(double id, double x, double y, double penDown, Color color, double heading){
        scene.getHelpTabs().getCurrState().addCurrState(id, x, y, penDown, color, heading);
    }
    public void setVisible(double d){
        if(d==1){
            scene.getTurtleDisplay().getTurtleImage().makeTurtleVisible();
        }
        else{
            scene.getTurtleDisplay().getTurtleImage().makeTurtleInvisible();
        }
    }
    public void setOrientation(double angle){
        scene.getTurtleDisplay().getTurtleImage().rotateTurtle(angle);
    }
    public void resetToHome(){
        scene.getTurtleDisplay().getTurtleImage().drawTurtle(0, 0);
    }
    public void clear(){
        //scene.getTurtleDisplay().getTurtleImage().drawTurtle(0, 0);
        scene.getTurtleDisplay().clear();
    }
    public void changeBackgroundColor(Color color) {
        scene.getTurtleDisplay().changeBackgroundColor(color);
    }
    public void changePenThickness(double thickness){
        scene.getTurtleDisplay().setThickness(thickness);
    }
    private void addTextHandler(){
        scene.getCommandBar().setEnterAction(actionEvent -> {
                                try {
                                        myController.enterAction(scene.getCommandBar().getText());
                                } catch (Exception e) {
                                        handleError("Not valid text");
                                }
            if(!scene.getCommandBar().getText().equals("")) {
                updateHistory(scene.getCommandBar().getText());
            }
            addVariables();
            addUserCommands();
            setText("");
        });
        
        scene.getCommandBar().setActions();
    }
    private void addHandlers(){
        scene.getSettingTools().setBackgroundAction((event) ->{
            Color c = scene.getSettingTools().getBackgroundColorPicker().getValue();
            scene.getTurtleDisplay().changeBackgroundColor(c);
            myController.getDisplaySpecs().setBackgroundIndex(scene.getHelpTools().getDisplayOptions().getColorIndex(c));
            //myController.getDisplaySpecs().setBackgroundIndex();//What do I set it to if it doesn't exist
        });

        scene.getSettingTools().setLineChangerAction((event) ->{
            TurtleDisplay.LineType lineChoice = (TurtleDisplay.LineType) scene.getSettingTools().getLineChoice();
            scene.getTurtleDisplay().setDash(lineChoice);
        });
        scene.getSettingTools().setPenStatusAction((event) ->{
            TurtleDisplay.PenStatus penChoice = (TurtleDisplay.PenStatus) scene.getSettingTools().getPenStatusChoice();
            scene.getTurtleDisplay().setPenStatus(penChoice);
        });
        scene.getSettingTools().setImageAction((event) ->{
            FileChooser chooser = new FileChooser();
            Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            File imageFile = chooser.showOpenDialog(mainStage);
            scene.getTurtleDisplay().getTurtleImage().changeTurtleImage("file:" + imageFile.toString());
            
            myController.getDisplaySpecs().setShapeIndex(scene.getHelpTools().getDisplayOptions().getImageIndex("file:"+imageFile.toString()));
        });
        scene.getHelpTabs().setCurrCommAction(m -> {
            //TODO use the map to map the method to text
            String command = scene.getHelpTabs().getCurrComm().getCommand();
            setText(command);
        });
        
        scene.getHelpTabs().setCurrVarAction(m-> {
            String command = scene.getHelpTabs().getCurrVar().getVariable();
            setText(command);
        });
        
        scene.getSettingTools().setLanguageAction((event) -> {
            scene.getSettingTools().getLanguageChooser().setLanguage();
            myController.getParser().changeLanguage(this);
        });

        scene.getHelpTabs().setCommHistAction(m -> {
            String command = scene.getHelpTabs().getCommHist().getCommand();
            setText(command);
        });
        scene.getHelpTabs().setCurrStateAction(m -> {

        });

        scene.getSettingTools().setPenAction((event) ->{
            Color c = scene.getSettingTools().getPenColorPicker().getValue();
            scene.getTurtleDisplay().setPenColor(c);
            myController.getDisplaySpecs().setPenColorIndex(scene.getHelpTools().getDisplayOptions().getColorIndex(c));
        });
        scene.getHelpTools().getFileControl().setWorkspaceAction((event) -> {
           MainMenu main = new MainMenu();
            Stage stage = new Stage();
            stage.setScene(main.init(stage, ViewLogic.Driver.WIDTH, ViewLogic.Driver.HEIGHT, null));
            stage.show();
        });

        scene.getHelpTools().getFileControl().setSaveAction((event) ->{
            TextField text = new TextField();
            Stage dialog = new Stage();
            saveFile(text,dialog);
            text.setOnKeyPressed((key) -> {
                if(key.getCode().equals(KeyCode.ENTER)){
                    try {
                        //myController.callSaveFile(text.getText());
                    	myController.getSaveManager().callSaveFile(text.getText());
                    	loadedFile = text.getText();
                        dialog.close();
                    }
                    catch (IOException e) {
                        handleError("Invalid Input");
                    }
                }
            });
        });
        
        scene.getHelpTools().getWorkspaceSaver().setSaveAction((event) ->{
            TextField text = new TextField();
            Stage dialog = new Stage();
            saveFile(text,dialog);
            text.setOnKeyPressed((key) -> {
                if(key.getCode().equals(KeyCode.ENTER)){
                    scene.getHelpTools().getWorkspaceSaver().saveWorkspace(text.getText(),scene,loadedFile);
                    dialog.close();
                }
            });
        });
        
        scene.getHelpTools().getFileControl().setLoadAction((event)->{
            FileChooser chooser = new FileChooser();
            Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            File loadFile = chooser.showOpenDialog(mainStage);
            loadFile(loadFile);
        });
        
        scene.getHelpTools().getDisplayOptions().setOptionAction((event)->{
            final Stage palette = new Stage();
            Scene paletteScene = new Scene(scene.getHelpTools().getDisplayOptions().setScreen(), 600, 600);
            palette.setScene(paletteScene);
            palette.show();
        });

    }

	public void updateScreen(Collection<TurtleView> myTurtleViewCollection, DisplaySpecs displaySpecs) {
        scene.getHelpTabs().getCurrState().clear();
	    for(TurtleView t : myTurtleViewCollection){
            setVisible(t.isRevealBoolean());
			setOrientation (t.getAngleNow());
			setCoordinate (t.isPenBoolean(), t.getOldXpos() , t.getOldYpos(), t.getNewXpos(), t.getNewYpos());
			if (t.isClearScreen()==1){
				clear();
			}
			Color c = scene.getSettingTools().getPenColorPicker().getValue();
            updateCurrState(0, t.getNewXpos(), t.getOldXpos(), t.isPenBoolean(), c, t.getAngleNow());
		}
	    changeDisplay();
		///TODO: Use changes to displayspecs.
	}
	private void addUserCommands(){
	    	scene.getHelpTabs().getCurrComm().clear();
            Map<String, Command> commands = myController.getCommands();
            commands.keySet().forEach(this::updateCurrCommands);
        }
	private void addVariables(){
	    scene.getHelpTabs().getCurrVar().clear();
	    Map<String, Double> vars = myController.getVariables();
	    for(String str : vars.keySet()){
                updateCurrVariables(str.substring(1) + ": " + vars.get(str));
	    }
        }
	
	private void changeDisplay(){
	    double background = myController.getDisplaySpecs().getBackgroundIndex();
	    double pen = myController.getDisplaySpecs().getPenColorIndex();
	    double image = myController.getDisplaySpecs().getShapeIndex();
	    scene.getTurtleDisplay().changeBackgroundColor(scene.getHelpTools().getDisplayOptions().getColor(background));
            scene.getTurtleDisplay().setPenColor(scene.getHelpTools().getDisplayOptions().getColor(pen));
            scene.getTurtleDisplay().getTurtleImage().changeTurtleImage(scene.getHelpTools().getDisplayOptions().getImage(image));
	}
	
	private void loadFile(File f){
	    loadedFile = "file:" + f.toString();
            try {
                myController.enterAction(myController.getSaveManager().readFile(f));
            }
            catch (Exception e) {
                handleError("Could not parse that file");
            }
            addUserCommands();
            addVariables();
	}
	
	private void saveFile(TextField text,Stage dialog){
            text.setPromptText("File Name");
            VBox vb = new VBox();
            vb.getChildren().addAll(new Label("Name your file"),text);
            vb.setAlignment(Pos.CENTER);
            vb.setSpacing(10);
            vb.setPadding(new Insets(10,10,10,10));
            Scene dialogScene = new Scene(vb, 300, 200);
            dialog.setScene(dialogScene);
            dialog.show();
	}
	
	public void handleError(String error){
        Stage stage = new Stage();
        Group g = new Group();
        g.getChildren().add(new Label(error));
        Scene s = new Scene(g);
        stage.setScene(s);
        stage.show();
    }
}