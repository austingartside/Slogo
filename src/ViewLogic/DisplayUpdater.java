package ViewLogic;

import View.DisplayGenerator;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Controller;
import model.TurtleView;
import screens.SLogoScene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class DisplayUpdater implements ViewToModelInterface{
    private String language;
    private SLogoScene scene;
    private Controller myController;

    public DisplayUpdater(SLogoScene s, Controller control){
        scene = s;
        language = "English";
        myController = control;
    }
    public void setUp() throws Exception{
        addHandlers();
        addTextHandler();
    }
    public Scene getGeneratorScene(){
        return scene.getScene();
    }
    public void setCoordinate(boolean penDown, double xPrev, double yPrev, double x, double y){
        scene.drawTurtle(x, y);
        if(penDown){
            scene.drawLine(xPrev, yPrev, x, y);
        }
    }
    public String getLanguage(){
        return language;
    }
    public void updateHistory(String object){
        scene.getCommandHistory().getItems().add(object);
    }
    public void updateCurrCommands(String object){
        scene.getCurrCommands().getItems().add(object);
    }
    public void updateCurrVariables(String object){
        scene.getCurrVariables().getItems().add(object);
    }
    public void setVisible(boolean visible){
        if(visible){
            scene.makeTurtleVisible();
        }
        else{
            scene.makeTurtleInvisible();
        }
    }
    public void setOrientation(double angle){
        scene.rotateTurtle(angle);
    }
    public void resetToHome(){
        scene.drawTurtle(0, 0);
    }
    public void clear(){
        scene.drawTurtle(0, 0);
        scene.clear();
    }

    private void addTextHandler(){
        scene.getEnter().setOnAction(actionEvent -> {
            //try {
				try {
					myController.enterAction(scene.getCommand());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//} catch (Exception e) {
				// TODO other error?
				//e.printStackTrace();
			//}
        	//call parser to parse stuff
            //use generator.getCommand() to get String input
            updateHistory(scene.getCommand());
            scene.setText("");
        });

        scene.getClear().setOnAction(actionEvent -> {
            scene.setText("");
        });
    }
    private void addHandlers(){
        scene.getBackgroundPicker().setOnAction((event) ->{
            scene.changeBackgroundColor(scene.getBackgroundPicker().getValue());
        });
        
        scene.getImagePicker().setOnAction((event) ->{
            FileChooser chooser = new FileChooser();
            Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            File imageFile = chooser.showOpenDialog(mainStage);
            scene.changeTurtleImage(imageFile.toString());
            /*try{
                if(imageFile.toString() != null){
                    generator.changeTurtleImage(imageFile.toString());
                }
            }catch(NullPointerException n){
                //
            }*/

        });
        scene.getCommandHistory().setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent m) {
                String command = scene.getCurrCommands().getSelectionModel().getSelectedItem();
                scene.setText(command);
            }
        });
        scene.getCurrCommands().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent m){
                //TODO use the map to map the method to text
                String command = scene.getCurrCommands().getSelectionModel().getSelectedItem();
                scene.setText(command);
            }
        });
        scene.getCurrVariables().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });
        scene.getLanguageChooser().setOnAction((event) -> {
            language = (String) scene.getLanguageChooser().getSelectionModel().getSelectedItem();
        });

        scene.getCommandHistory().setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent m){
                String command = scene.getCommandHistory().getSelectionModel().getSelectedItem();
                scene.setText(command);
            }
        });

        scene.getPenColorPicker().setOnAction((event) ->{
            Color c = scene.getPenColorPicker().getValue();
            scene.setPenColor(c);
        });
    }
 
	public void updateScreen(TurtleView turtleView) {
		setVisible(turtleView.isRevealBoolean());
		setOrientation (turtleView.getAngleNow());
		setCoordinate (turtleView.isPenBoolean(),turtleView.getOldXpos() ,turtleView.getOldYpos(), turtleView.getNewXpos(), turtleView.getNewYpos());
		int errorState = turtleView.getErrorState();
        System.out.println(errorState);
        //handleError(errorState);
		if (turtleView.isClearScreen()){clear();}
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