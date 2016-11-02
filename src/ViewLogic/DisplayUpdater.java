package ViewLogic;

import View.TurtleImage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import model.Controller;
import model.DisplaySpecs;
import model.TurtleView;
import model.commands.Command;
import screens.SLogoScene;
import javafx.stage.Stage;
import java.util.*;
/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class DisplayUpdater implements ViewToModelInterface{

    private final double PEN_THICKNESS_SCALE = 4;
    private SLogoScene scene;
    private Controller myController;

    private void addUndo(){
        scene.getDebugger().setUndoAction((event) ->{
            TurtleImage a = new TurtleImage();
            scene.getTurtleDisplay().getTurtleImage().add(a);
            a.drawTurtle(0, 0);
            scene.getTurtleDisplay().getView().getChildren().add(a.getView());
            myController.getTurtleControl().updateTurtleViewCollection();

        });
    }
    public DisplayUpdater(SLogoScene s, Controller control){
        scene = s;
        myController = control;
    }
    public void setUp() throws Exception{
        addUndo();
        new Handlers(scene).addHandlers(this, myController);
        addTextHandler();
    }

    public void setText(String str){
        scene.getCommandBar().setText(str);
    }
    public void setCoordinate(double penDown, double xPrev, double yPrev, double x, double y, int index){
        scene.getTurtleDisplay().getTurtleImage().get(index).drawTurtle(x, y);
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
    public void addTurtle(){
        scene.getTurtleDisplay().addTurtle(new TurtleImage());
    }
    public void setVisible(double d, int index){
        if(d==1){
            scene.getTurtleDisplay().getTurtleImage().get(index).makeTurtleVisible();
        }
        else{
            scene.getTurtleDisplay().getTurtleImage().get(index).makeTurtleInvisible();
        }
    }
    public void setOrientation(double angle, int index){
        scene.getTurtleDisplay().getTurtleImage().get(index).rotateTurtle(angle);
    }
    public void resetToHome(int index){
        scene.getTurtleDisplay().getTurtleImage().get(index).drawTurtle(0, 0);
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
                handleError("Parser error");
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

	public void updateScreen(Collection<TurtleView> myTurtleViewCollection, DisplaySpecs displaySpecs) {
        scene.getHelpTabs().getCurrState().clear();
        int size1 = myTurtleViewCollection.size();
        int size2 = scene.getTurtleDisplay().getTurtleImage().size();
        addMoreTurtles(size1, size2);
        int ind = -1;
        System.out.println(myTurtleViewCollection.size());
        System.out.println(scene.getTurtleDisplay().getTurtleImage().size());
	    for(TurtleView t : myTurtleViewCollection){
           updateTurtles(t, ++ind);
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
    private void updateTurtles(TurtleView t, int ind){
        setVisible(t.isRevealBoolean(), ind);
        setOrientation (t.getAngleNow(), ind);
        setCoordinate (t.isPenBoolean(), t.getOldXpos() , t.getOldYpos(), t.getNewXpos(), t.getNewYpos(), ind);
        if (t.isClearScreen()==1){
            clear();
        }
        Color c = scene.getSettingTools().getPenColorPicker().getValue();
        updateCurrState(0, t.getNewXpos(), t.getOldXpos(), t.isPenBoolean(), c, t.getAngleNow());
    }
	private void addMoreTurtles(int size1, int size2){
        for(int i = 0; i < size1-size2; i++){
            TurtleImage t = new TurtleImage();
            scene.getTurtleDisplay().getTurtleImage().add(t);
            scene.getTurtleDisplay().getView().getChildren().add(t.getView());
        }
    }
	private void changeDisplay(){
	    double background = myController.getDisplaySpecs().getBackgroundIndex();
	    double pen = myController.getDisplaySpecs().getPenColorIndex();
	    double image = myController.getDisplaySpecs().getShapeIndex();
        double penSize = myController.getDisplaySpecs().getPenSizeIndex();
        scene.getTurtleDisplay().setThickness(penSize * PEN_THICKNESS_SCALE);
	    scene.getTurtleDisplay().changeBackgroundColor(scene.getDisplayOptions().getColor(background));
        scene.getTurtleDisplay().setPenColor(scene.getDisplayOptions().getColor(pen));
        scene.getTurtleDisplay().getTurtleImage().get(0).changeTurtleImage(scene.getDisplayOptions().getImage(image));
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