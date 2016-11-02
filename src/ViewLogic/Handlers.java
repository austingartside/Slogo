package ViewLogic;

import View.TurtleDisplay;
import View.TurtleImage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Controller;
import screens.MainMenu;
import screens.SLogoScene;

import java.io.File;
import java.io.IOException;

/**
 * Created by billxiong24 on 10/31/16.
 * Add handlers to objects
 */
public class Handlers {
    private SLogoScene scene;
    public Handlers(SLogoScene s){
        scene = s;
    }
    public void addHandlers(DisplayUpdater updater, Controller myController){
        addSettingTools(myController);
        addPenStatusChanger();
        addLineChanger();
        addImageChanger(myController);
        addHelpTabs(updater, myController);
        addSaveAction(updater, myController);
        addPenAction(myController);
        addFileAction();
        addLoadAction(updater, myController);
        addDisplayOptions();
    }

    private void addSettingTools(Controller myController){
        scene.getSettingTools().setBackgroundAction((event) ->{
            Color c = scene.getSettingTools().getBackgroundColorPicker().getValue();
            scene.getTurtleDisplay().changeBackgroundColor(c);
            myController.getDisplaySpecs().setBackgroundIndex(scene.getHelpTools().getDisplayOptions().getColorIndex(c));
        });
    }
    private void addPenStatusChanger(){
        scene.getSettingTools().setPenStatusAction((event) ->{
            TurtleDisplay.PenStatus penChoice = (TurtleDisplay.PenStatus) scene.getSettingTools().getPenStatusChoice();
            scene.getTurtleDisplay().setPenStatus(penChoice);
        });
    }
    private void addLineChanger(){
        scene.getSettingTools().setLineChangerAction((event) ->{
            TurtleDisplay.LineType lineChoice = (TurtleDisplay.LineType) scene.getSettingTools().getLineChoice();
            scene.getTurtleDisplay().setDash(lineChoice);
        });
    }
    private void addImageChanger(Controller myController){
        scene.getSettingTools().setImageAction((event) ->{
            FileChooser chooser = new FileChooser();
            Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            File imageFile = chooser.showOpenDialog(mainStage);
            scene.getTurtleDisplay().getTurtleImage().get(0).changeTurtleImage("file:" + imageFile.toString());
            myController.getDisplaySpecs().setShapeIndex(scene.getHelpTools().getDisplayOptions().getImageIndex("file:"+imageFile.toString()));
        });
    }

    private void addHelpTabs(DisplayUpdater updater, Controller myController){
        scene.getHelpTabs().setCurrCommAction(m -> {
            //TODO use the map to map the method to text
            String command = scene.getHelpTabs().getCurrComm().getCommand();
            updater.setText(command);
        });
        scene.getHelpTabs().setCurrVarAction(m-> {
            String command = scene.getHelpTabs().getCurrVar().getVariable();
            updater.setText(command);
        });
        scene.getSettingTools().setLanguageAction((event) -> {
            scene.getSettingTools().getLanguageChooser().setLanguage();
            myController.getParser().changeLanguage(updater);
        });
        scene.getSettingTools().setTurtleSpeedAction((event) -> {
            for(TurtleImage t : scene.getTurtleDisplay().getTurtleImage()){
                t.setMilliseconds(scene.getSettingTools().getTurtleSpeed().getSpeed());
            }
        });
        scene.getHelpTabs().setCommHistAction(m -> {
            String command = scene.getHelpTabs().getCommHist().getCommand();
            updater.setText(command);
        });
        scene.getHelpTabs().setCurrStateAction(m -> {
        });
    }
    private void addSaveAction(DisplayUpdater updater, Controller myController){
        scene.getHelpTools().getFileControl().setSaveAction((event) ->{
            final Stage dialog = new Stage();
            TextField text = new TextField();
            text.setPromptText("File Name");
            text.setOnKeyPressed((key) -> {
                if(key.getCode().equals(KeyCode.ENTER)){
                    try {
                        myController.getSaveManager().callSaveFile(text.getText());
                        dialog.close();
                    }
                    catch (IOException e) {
                        updater.handleError("Invalid Input");
                    }
                }
            });
            addToVBox(text, dialog);
        });
    }
    private void addPenAction(Controller myController){
        scene.getSettingTools().setPenAction((event) ->{
            Color c = scene.getSettingTools().getPenColorPicker().getValue();
            scene.getTurtleDisplay().setPenColor(c);
            myController.getDisplaySpecs().setPenColorIndex(scene.getHelpTools().getDisplayOptions().getColorIndex(c));
        });
    }
    private void addFileAction(){
        scene.getHelpTools().getFileControl().setWorkspaceAction((event) -> {
            MainMenu main = new MainMenu();
            Stage stage = new Stage();
            stage.setScene(main.init(stage, ViewLogic.Driver.WIDTH, ViewLogic.Driver.HEIGHT, null));
            stage.show();
        });
    }
    private void addLoadAction(DisplayUpdater updater, Controller myController){
        scene.getHelpTools().getFileControl().setLoadAction((event)->{
            FileChooser chooser = new FileChooser();
            Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            File loadFile = chooser.showOpenDialog(mainStage);
            try {
                myController.enterAction(myController.getSaveManager().readFile(loadFile));
            }
            catch (Exception e) {
                updater.handleError("Could not parse that file");
            }
            updater.addUserCommands();
            updater.addVariables();
        });
    }
    private void addDisplayOptions(){
        scene.getHelpTools().getDisplayOptions().setOptionAction((event)->{
            final Stage palette = new Stage();
            Scene paletteScene = new Scene(scene.getHelpTools().getDisplayOptions().setScreen(), 600, 600);
            palette.setScene(paletteScene);
            palette.show();
        });
    }

    private void addToVBox(TextField text, final Stage dialog){
        VBox vb = new VBox();
        vb.getChildren().addAll(new Label("Name your file"),text);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
        vb.setPadding(new Insets(10,10,10,10));
        Scene dialogScene = new Scene(vb, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
