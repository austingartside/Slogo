package ViewLogic;

import View.TurtleDisplay;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Controller;
import model.DisplaySpecs;
import model.Turtle;
import model.TurtleView;
import model.commands.Command;
import screens.SLogoScene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.*;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class DisplayUpdater implements ViewToModelInterface{
    private SLogoScene scene;

    private Controller myController;
    private final String XPOS = "X POSITION: ";
    private final String YPOS = "Y POSITION: ";
    private final String PENDOWN = "PEN DOWN: ";
    private final String PENCOLOR = "PEN COLOR: ";
    private final String BACKGROUND = "BACKGROUND: ";
    private final String HEADING = "HEADING: ";
    public DisplayUpdater(SLogoScene s, Controller control){
        scene = s;
        myController = control;
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
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
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
            scene.getTurtleDisplay().changeBackgroundColor(scene.getSettingTools().getBackgroundColorPicker().getValue());
        });

        scene.getSettingTools().setLineChangerAction((event) ->{
            TurtleDisplay.LineType lineChoice = (TurtleDisplay.LineType) scene.getSettingTools().getLineChoice();
            scene.getTurtleDisplay().setDash(lineChoice);
        });
        scene.getSettingTools().setImageAction((event) ->{
            FileChooser chooser = new FileChooser();
            Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            File imageFile = chooser.showOpenDialog(mainStage);
            scene.getTurtleDisplay().getTurtleImage().changeTurtleImage(imageFile.toString());
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
        });

    }

	public void updateScreen(Collection<TurtleView> myTurtleViewCollection, DisplaySpecs displaySpecs) {
        scene.getHelpTabs().getCurrState().clear();
        System.out.println(myTurtleViewCollection.size());
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
	public void handleError(String error){
        Stage stage = new Stage();
        Group g = new Group();
        g.getChildren().add(new Label(error));
        Scene s = new Scene(g);
        stage.setScene(s);
        stage.show();
    }
}