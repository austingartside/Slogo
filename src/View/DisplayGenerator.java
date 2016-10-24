package View;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.control.*;

/**
 * Created by Bill Xiong on 10/19/16.
 * Generates and updates the display. Should not interact with backend
 */

public class DisplayGenerator {

    public static final double SIZE_X = 1200;
    public static final double SIZE_Y = 700;
    static final double ALIGN = SIZE_X/4 - 200;
    static final int ADJUST = 150;
    public static final int COLUMNS = 20;
    private final int MAX_SIZE = 40;
    
    private GridPane gridPane;
    private Color penColor;
    private ImageView turtle;
    private Scene scene;
    private TextArea commandLine;
    private Button enter;
    private Button clear;
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
    private Button help;
    private ImageView turtleInvis;

    public DisplayGenerator(){
        penColor = Color.BLACK;
        String path = System.getProperty("user.dir");
        turtle = new ImageView(new File(path + "/src/resources.view/Turtle.png").toURI().toString());
        turtleInvis = new ImageView(turtle.getImage());
        commandLine = new TextArea();
        commandLine.setMaxHeight(30);
        enter = new Button("Enter");
        clear = new Button("Clear");
        help = new Button("Help");
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
        addListViews();
        addCommandInput();
        addCanvas();
        addButtons();
        addImage();
        addHelp();
        return gridPane;
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
    public Button getEnter(){
        return enter;
    }
    public Button getClear(){
        return clear;
    }
    public Scene getScene(){
        return scene;
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
    public void changeTurtleImage(String pic){
        Image turtleIm = new Image(new File(pic).toURI().toString());
        turtle.setImage(turtleIm);
        
        turtle.setFitWidth(40);
        turtle.setFitHeight(40);
        turtle.setPreserveRatio(true);
        turtle.setSmooth(true);
        turtle.setCache(true);
    }
    public ComboBox<Object> getLanguageChooser(){
        return languageChooser.getBox();
    }
    public ColorPicker getPenColorPicker(){
        return penColorPicker;
    }
    public void setPenColor(Color c){
        penColor = c;
    }
    public String getCommand(){
        return commandLine.getText();
    }
    public void setText(String str){
        commandLine.setText(str);
    }
    //TODO change Object to Command object, so that we can add stuff to command history

    public void drawTurtle(double x, double y){
        turtle.setTranslateX(canvasX(x));
        turtle.setTranslateY(canvasY(y));
    }
    public void makeTurtleInvisible(){
        turtleInvis = new ImageView(turtle.getImage());
        turtle.setImage(null);
    }
    //TODO change colors later
    public void makeTurtleVisible(){
        turtle.setImage(turtleInvis.getImage());
    }
    public void clear(){
        canvas.clear();
    }
    public void rotateTurtle(double angle){
        turtle.setRotate(angle);
    }
    public void drawLine(double xPrev, double yPrev, double x, double y){
        GraphicsContext gc = canvas.getContext();
        gc.moveTo(canvasLineX(xPrev), canvasLineY(yPrev));
        gc.setStroke(penColor);
        gc.lineTo(canvasLineX(x), canvasLineY(y));
        gc.stroke();
    }
    private void addLanguages(){
        languageChooser.getBox().setMaxWidth(Double.MAX_VALUE);
        languageChooser.getBox().setMaxHeight(Double.MAX_VALUE);
        languageChooser.addToList("English");//,"Chinese","French","German","Italian","Portugese","Russian","Spanish");
        languageChooser.addToList("Chinese");
        languageChooser.addToList("French");
        languageChooser.addToList("German");
        languageChooser.addToList("Italian");
        languageChooser.addToList("Portugese");
        languageChooser.addToList("Russian");
        languageChooser.addToList("Spanish");
        gridPane.add(languageChooser.getBox(), 14, 18, 4, 2);
    }
    private void addPenColors(){
        penColorChanger.getButton().setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent ae){
                gridPane.add(penColorPicker,8,0);
            }
        });
        
    }
    private void addBackgroundColors(){
        backgroundChanger.getButton().setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(final ActionEvent ae){
                gridPane.add(backgroundColorPicker,0,0,4,4);
            }
        });
    }
    private void addImage(){
        drawTurtle(0, 0);
        turtle.setFitWidth(MAX_SIZE);
        turtle.setFitHeight(MAX_SIZE);
        turtle.setPreserveRatio(true);
        turtle.setSmooth(true);
        turtle.setCache(true);
        gridPane.getChildren().add(turtle);
    }
    private void addButtons(){
        createButtons();
        addPenColors();
        addBackgroundColors();
        addLanguages();
        formatButtons();
    }
    private void formatButtons(){
        HBox hb = new HBox();
        hb.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        hb.getChildren().addAll(addColorPickerToBar(backgroundColorPicker,"Background Color"),
                                addButtonToBar(imageChanger.getButton()),
                                addColorPickerToBar(penColorPicker,"Pen Color"));
        gridPane.add(hb, 0, 0, 12, 3);
        hb.setSpacing(10);
    }
    
    private VBox addColorPickerToBar(ColorPicker cp, String label){
        VBox vb = new VBox();
        Label l = new Label(label);
        HBox.setHgrow(vb, Priority.ALWAYS);
        cp.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        VBox.setVgrow(cp, Priority.ALWAYS);
        vb.getChildren().addAll(l,cp);
        vb.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        return vb;
    }
    
    private VBox addButtonToBar(Button b){
        VBox vb = new VBox();
        Label placeHold = new Label("");
        HBox.setHgrow(vb, Priority.ALWAYS);
        b.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        VBox.setVgrow(b, Priority.ALWAYS);
        vb.getChildren().addAll(placeHold,b);
        vb.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        return vb;
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
        VBox vb = new VBox();
        vb.getChildren().addAll(enter,clear);
        vb.setSpacing(10);
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, commandLine, vb);
        hb.setSpacing(10);
        gridPane.add(hb,0,18,12,2);
        return commandLine;
    }
    public Canvas addCanvas(){
        Canvas can = canvas.createCanvas();
        gridPane.add(can, 0, 2, 12, 16);
        return can;
    }
    public void addListViews(){
        TabPane tabs = new TabPane();
        Tab tabCH = new Tab();
        tabCH.setText("Command History");
        tabCH.setContent(commandHistory.getListView());

        Tab tabCV = new Tab();
        tabCV.setText("Current Variables");
        tabCV.setContent(currVariables.getListView());

        Tab tabCC = new Tab();
        tabCC.setText("Current Commands");
        tabCC.setContent(currCommands.getListView());
        
        tabs.getTabs().addAll(tabCH,tabCV,tabCC);
        gridPane.add(tabs, 12, 1, 8, 17);
    }
    public void addHelp(){
        help.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent ae){
                displayHelp();
            }
        });
        help.setMaxWidth(Double.MAX_VALUE);
        gridPane.add(help, 18, 0, 2, 1);
    }
    //all the event handlers for comboboxes
    private void displayHelp(){
        String path = System.getProperty("user.dir");
        path += "/src/help.html";
        WebView web = new WebView();
        web.getEngine().load("file:///" + path);
        Stage s = new Stage();
        Scene scene = new Scene(web);
        scene.setRoot(web);
        s.setScene(scene);
        s.show();
    }
    private double canvasX(double x){
        return CanvasGenerator.CANVAS_X/2 + x - MAX_SIZE/2;
    }
    private double canvasY(double y){
        return CanvasGenerator.CANVAS_Y/2 + ADJUST + y;
    }
    private double canvasLineX(double x){
        return CanvasGenerator.CANVAS_X/2 + x;
    }
    private double canvasLineY(double y){
        return CanvasGenerator.CANVAS_Y/2 + y;
    }
}