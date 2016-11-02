package ViewLogic;

import View.TurtleDisplay;
import View.TurtleImage;
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
import java.lang.reflect.Array;
import java.sql.Driver;
import java.util.*;

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
        if(scene.getWorkspaceParser() != null){
            workspaceSetup();
        }
    }
    
    private void workspaceSetup(){
        Color bg = scene.getWorkspaceParser().getBackgroundColor();
        Color pen = scene.getWorkspaceParser().getPenColor();
        String im = scene.getWorkspaceParser().getImage();
        scene.getTurtleDisplay().changeBackgroundColor(bg);
        scene.getTurtleDisplay().setPenColor(pen);
        scene.getTurtleDisplay().getTurtleImage().get(0).changeTurtleImage(im);
        scene.getHelpTools().getDisplayOptions().setColors(scene.getWorkspaceParser().getColorList());
        scene.getHelpTools().getDisplayOptions().setImages(scene.getWorkspaceParser().getImageList());
        scene.getSettingTools().getLanguageChooser().setLanguage(scene.getWorkspaceParser().getLanguage());
        loadFile(scene.getWorkspaceParser().getFiletoLoad());
    }
    
    public void setUp() throws Exception{
        new Handlers(scene).addHandlers(this, myController);
        addTextHandler();
        if(scene.getWorkspaceParser()!= null){
            Color bg = scene.getWorkspaceParser().getBackgroundColor();
            Color pen = scene.getWorkspaceParser().getPenColor();
            String im = scene.getWorkspaceParser().getImage();
            myController.getDisplaySpecs().setBackgroundIndex(scene.getHelpTools().getDisplayOptions().getColorIndex(bg));
            myController.getDisplaySpecs().setPenColorIndex(scene.getHelpTools().getDisplayOptions().getColorIndex(pen));
            myController.getDisplaySpecs().setShapeIndex(scene.getHelpTools().getDisplayOptions().getImageIndex(im));
        }
    }

    public void setText(String str){
        scene.getCommandBar().setText(str);
    }
    public void setCoordinate(double penDown, double xPrev, double yPrev, double x, double y, int index){
        scene.getTurtleDisplay().getTurtleImage().get(0).drawTurtle(x, y);
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
    public void setVisible(double d, int index){
        if(d==1){
            scene.getTurtleDisplay().getTurtleImage().get(0).makeTurtleVisible();
        }
        else{
            scene.getTurtleDisplay().getTurtleImage().get(0).makeTurtleInvisible();
        }
    }
    public void setOrientation(double angle, int index){
        scene.getTurtleDisplay().getTurtleImage().get(index).rotateTurtle(angle);
    }
    public void resetToHome(){
        scene.getTurtleDisplay().getTurtleImage().get(0).drawTurtle(0, 0);
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
            scene.getHelpTools().getDebugger().push(scene.getTurtleDisplay());
        });
        
        scene.getCommandBar().setActions();
    }


    public void moveTurtle(){
        for(TurtleImage t : scene.getTurtleDisplay().getTurtleImage()){
            t.animate();
        }
    }
	public void updateScreen(Collection<TurtleView> myTurtleViewCollection, DisplaySpecs displaySpecs) { 
        scene.getHelpTabs().getCurrState().clear();
        int ind = -1;
        //System.out.println(myTurtleViewCollection.size());
	    for(TurtleView t : myTurtleViewCollection){
            setVisible(t.isRevealBoolean(), ++ind);
			setOrientation (t.getAngleNow(), ind);
			setCoordinate (t.isPenBoolean(), t.getOldXpos() , t.getOldYpos(), t.getNewXpos(), t.getNewYpos(), ind);
			if (t.isClearScreen()==1){
				clear();
			}
			Color c = scene.getSettingTools().getPenColorPicker().getValue();
            updateCurrState(0, t.getNewXpos(), t.getOldXpos(), t.isPenBoolean(), c, t.getAngleNow());
		}
	    changeDisplay();
		///TODO: Use changes to displayspecs.
	}
	public void addUserCommands(){
	    	scene.getHelpTabs().getCurrComm().clear();
            //Map<String, Command> commands = myController.getCommands();
	    	Map<String, Command> commands = myController.getCommandController().getCommands();
            commands.keySet().forEach(this::updateCurrCommands);
        }
	public void addVariables(){
	    scene.getHelpTabs().getCurrVar().clear();
	    //Map<String, Double> vars = myController.getVariables();
	    Map<String, Double> vars = myController.getCommandController().getVariables();
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
            scene.getTurtleDisplay().getTurtleImage().get(0).changeTurtleImage(scene.getHelpTools().getDisplayOptions().getImage(image));
	}
	
	private void loadFile(String f){
	    loadedFile = f;
            try {
                myController.enterAction(myController.getSaveManager().readFile(new File(f)));
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