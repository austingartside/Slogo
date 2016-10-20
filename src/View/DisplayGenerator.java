package View;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import sun.security.util.ObjectIdentifier;

/**
 * Created by Bill Xiong on 10/19/16.
 * Generates and updates the display. Should not interact with backend
 */
public class DisplayGenerator {

    public static final double SIZE_X = 1200;
    public static final double SIZE_Y = 700;
    static final double ALIGN = SIZE_X/4 - 200;

    private Scene scene;
    private Group group;
    private TextField commandLine;
    private Button enter;
    private CanvasGenerator canvas;
    private ButtonGenerator backgroundChanger, imageChanger, commandHistory, currCommands,
    currVariables, languageChooser, penColorChanger;

    public DisplayGenerator(){

        commandLine = new TextField();
        enter = new Button("Enter");
        group = new Group();
        scene = new Scene(group, SIZE_X, SIZE_Y);
        canvas = new CanvasGenerator();
        initButtons();
    }

    /**
     * This method adds all necessary components to the front end.
     * TODO add a turtle image here. Will do this once Gunhan/Austin makes getter for image.
     */
    public void setScene(){
        addCommandInput();
        addCanvas();
        addButtons();
    }

    /**
     * Use this method to add an event handler to the button that will process text and send
     * to the backend.
     * @return the submit button to submit the command to the backend
     */
    public Button getEnter(){
        return enter;
    }
    public Scene getScene(){
        return scene;
    }
    public void changeBackgroundColor(Color color){
        canvas.changeBackgroundColor(color);
    }
    public ComboBox<Object> getBackgroundChanger(){
        return backgroundChanger.getList();
    }
    public ComboBox<Object> getImageChanger(){
        return imageChanger.getList();
    }
    public ComboBox<Object> getCommandHistory(){
        return commandHistory.getList();
    }
    public ComboBox<Object> getCurrCommands(){
        return currCommands.getList();
    }
    public ComboBox<Object> getCurrVariables(){
        return currVariables.getList();
    }
    public ComboBox<Object> getLanguageChooser(){
        return languageChooser.getList();
    }
    public ComboBox<Object> getPenColorChanger(){
        return penColorChanger.getList();
    }
    public void drawTurtle(double angle, double x, double y){

    }
    public String getCommand(){
        return commandLine.getText();
    }

    //TODO change Object to Command object, so that we can add stuff to command history
    public void addToHistory(Object object){
        commandHistory.getList().getItems().add(object);
    }
    public void addToCurrCommands(Object object){
        currCommands.getList().getItems().add(object);
    }
    public void addToCurrVariables(Object object){
        currVariables.getList().getItems().add(object);
    }
    private void addLanguages(){
        languageChooser.getList().getItems().add("English");
        languageChooser.getList().getItems().add("Chinese");
        languageChooser.getList().getItems().add("French");
        languageChooser.getList().getItems().add("German");
        languageChooser.getList().getItems().add("Italian");
        languageChooser.getList().getItems().add("Portuguese");
        languageChooser.getList().getItems().add("Russian");
        languageChooser.getList().getItems().add("Spanish");

    }
    private void addPenColors(){
        penColorChanger.getList().getItems().add(Color.BLUE);
        penColorChanger.getList().getItems().add(Color.PURPLE);
        penColorChanger.getList().getItems().add(Color.GREEN);
        penColorChanger.getList().getItems().add(Color.BLACK);
        penColorChanger.getList().getItems().add(Color.YELLOW);
    }
    private void addBackgroundColors(){
        backgroundChanger.getList().getItems().add(Color.BLUE);
        backgroundChanger.getList().getItems().add(Color.MEDIUMPURPLE);
        backgroundChanger.getList().getItems().add(Color.GREENYELLOW);
    }
    private void addImage(){

    }

    private void addButtons(){
        createButtons();
        addPenColors();
        addBackgroundColors();
        addLanguages();
        VBox box = new VBox(10);
        box.getChildren().addAll(backgroundChanger.getList(), imageChanger.getList(), commandHistory.getList(),
                currCommands.getList(), currVariables.getList(), languageChooser.getList(), penColorChanger.getList());
        box.setLayoutX(SIZE_X - 300);
        box.setLayoutY(100);
        group.getChildren().add(box);
    }
    private void createButtons(){
        backgroundChanger.create(group);
        imageChanger.create(group);
        commandHistory.create(group);
        currCommands.create(group);
        currVariables.create(group);
        languageChooser.create(group);
        penColorChanger.create(group);
    }
    private void initButtons(){
        backgroundChanger = new BackgroundChanger();
        imageChanger = new ImageChanger();
        commandHistory = new CommandHistory();
        currCommands = new CurrCommands();
        currVariables = new CurrVariables();
        languageChooser = new LanguageChooser();
        penColorChanger = new PenColorChanger();
    }
    private void addCommandInput(){
        Label label1 = new Label("Command:");
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, commandLine, enter);
        hb.setSpacing(10);
        hb.setLayoutY(SIZE_Y-80);
        hb.setLayoutX(ALIGN);
        group.getChildren().add(hb);
    }
    public String getInput(){
        return commandLine.getText();
    }

    private void addCanvas(){
        canvas.createCanvas(group);
    }
    //all the event handlers for comboboxes

}
