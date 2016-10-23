package View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import screens.SLogoScene;
import javafx.scene.control.*;

/**
 * Created by Bill Xiong on 10/19/16.
 * Generates and updates the display. Should not interact with backend
 */
public class DisplayGenerator {

    public static final double SIZE_X = 1200;
    public static final double SIZE_Y = 700;
    static final double ALIGN = SIZE_X/4 - 200;
    public static final int COLUMNS = 20;
    public static final int ROWS = 20;
    public static final int GAPS = 10;
    
    private GridPane gridPane;
    private Color penColor;
    private Rectangle turtle;
    private Scene scene;
    private TextArea commandLine;
    private Button enter;
    private CanvasGenerator canvas;
    private BackgroundChanger backgroundChanger;
    private ImageChanger imageChanger;
    private CommandHistory commandHistory;
    private CurrCommands currCommands;
    private CurrVariables currVariables;
    private LanguageChooser languageChooser;
    private PenColorChanger penColorChanger;
    private ColorPicker penColorPicker;
    private ColorPicker backgroundColorPicker;

    public DisplayGenerator(){
        penColor = Color.BLACK;
        turtle = new Rectangle(100, 300, 20, 20);
        commandLine = new TextArea();
        enter = new Button("Enter");
        gridPane = new GridPane();
        setGridPane();
        scene = new Scene(gridPane, SIZE_X, SIZE_Y);
        canvas = new CanvasGenerator();
        penColorPicker = new ColorPicker();
        backgroundColorPicker = new ColorPicker();
        initButtons();
    }

    /**
     * This method adds all necessary components to the front end.
     * TODO add a turtle image here. Will do this once Gunhan/Austin makes getter for image.
     */
    public GridPane setScene(){
        addCommandInput();
        addCanvas();
        addButtons();
        addImage();
        return gridPane;
        //drawLine(50, 50, 300, 300);
    }
    
    public void setGridPane(){
        gridPane.setHgap(10); 
        gridPane.setVgap(10); 
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        for(int i = 0; i < COLUMNS; i++){
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(10);
            gridPane.getColumnConstraints().add(column);

            RowConstraints row = new RowConstraints();
            row.setPercentHeight(10);
            gridPane.getRowConstraints().add(row);
        }
        
    }

    /**
     * Use this method to add an event handler to the button that will process text and send
     * to the backend.
     * @return the submit button to submit the command to the backend
     */
    public GridPane getGridPane(){
        return gridPane;
    }
    public void changeBackgroundColor(Color color){
        canvas.changeBackgroundColor(color);
    }
    public ColorPicker getBackgroundPicker(){
        return backgroundColorPicker;
    }
    public Button getImagePicker(){
        return imageChanger.getButton();
    }
    public ListView<String> getCommandHistory(){
        return commandHistory.getListView(); //commandHistory.getList();
    }
    public ListView<String> getCurrCommands(){
        return currCommands.getListView();
    }
    public ListView<String> getCurrVariables(){
        return currVariables.getListView();
    }
    public ComboBox<Object> getLanguageChooser(){
        return languageChooser.getBox();
    }
    public ColorPicker getPenColorPicker(){
        return penColorPicker;
    }
    public ColorPicker getPenColor(){
        return penColorPicker;
    }
    public void setPenColor(Color c){
        penColor = c;
    }
    public String getCommand(){
        return commandLine.getText();
    }

    //TODO change Object to Command object, so that we can add stuff to command history

    public void drawTurtle(double x, double y){
        turtle.setTranslateX(300);
        turtle.setTranslateY(350);
    }
    public void rotateTurtle(double angle){
        turtle.setRotate(angle);
    }
    public void drawLine(double xPrev, double yPrev, double x, double y){
        Line line = new Line();
        line.setStartX(xPrev);
        line.setStartY(yPrev);
        line.setEndX(x);
        line.setEndY(y);
        line.setStroke(penColor);
        gridPane.getChildren().add(line);
    }
    private void addLanguages(){
        languageChooser.getList().add("English");//,"Chinese","French","German","Italian","Portugese","Russian","Spanish");
        languageChooser.getList().add("Chinese");
        languageChooser.getList().add("French");
        languageChooser.getList().add("German");
        languageChooser.getList().add("Italian");
        languageChooser.getList().add("Portugese");
        languageChooser.getList().add("Russian");
        languageChooser.getList().add("Spanish");
    }
    private void addPenColors(){
        penColorChanger.getButton().setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(final ActionEvent ae){
                gridPane.getChildren().add(penColorPicker);
                
            }
        });
        
    }
    private void addBackgroundColors(){
        penColorChanger.getButton().setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(final ActionEvent ae){
                gridPane.getChildren().add(backgroundColorPicker);
            }
        });
    }
    private void addImage(){
        drawTurtle(0, 0);
        turtle.setWidth(30);
        turtle.setHeight(30);
        turtle.setFill(Color.BLACK);
        gridPane.getChildren().add(turtle);
    }
    private void addButtons(){
        createButtons();
        addPenColors();
        addBackgroundColors();
        addLanguages();
        GridPane.setConstraints(backgroundChanger.getButton(), 0, 0, 2, 4);
        GridPane.setConstraints(imageChanger.getButton(), 4, 0, 2, 4);
        GridPane.setConstraints(penColorChanger.getButton(), 8, 0, 2, 4);
        gridPane.getChildren().addAll(backgroundChanger.getButton(), imageChanger.getButton(), penColorChanger.getButton());
    }
    private void createButtons(){
        backgroundChanger.create();
        imageChanger.create();
        commandHistory.create();
        currCommands.create();
        currVariables.create();
        languageChooser.create();
        penColorChanger.create();
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
    public TextArea addCommandInput(){
        Label label1 = new Label("Command:");
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, commandLine, enter);
        hb.setSpacing(10);
        hb.setLayoutY(SIZE_Y-80);
        hb.setLayoutX(ALIGN);
        GridPane.setConstraints(hb,0,18,12,2);
        gridPane.getChildren().add(hb);
        return commandLine;
    }
    private double canvasCoordX(double x){
        return x + ALIGN + CanvasGenerator.CANVAS_X/2;
    }
    private double canvasCoordY(double y){
        return y + CanvasGenerator.CANVAS_OFFSET + CanvasGenerator.CANVAS_Y/2;
    }
    public String getInput(){
        return commandLine.getText();
    }
    public Canvas addCanvas(){
        Canvas can = canvas.createCanvas();
        GridPane.setConstraints(can, 0, 2, 12, 16);
        gridPane.getChildren().add(can);
        return can;
    }
    //all the event handlers for comboboxes

    public Scene getScene () {
        return scene;
    }

    public ComboBoxBase<Object> getEnter () {
        return new ComboBox<Object>();
    }
}