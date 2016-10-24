package screens;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import View.CanvasGenerator;
import View.DisplayGenerator;
import View.ListViewNamer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import model.Controller;

public class SLogoScene extends ActionScene{
    
    public static final int SIZE_X = 1200;
    public static final int SIZE_Y = 700;
    static final double ALIGN = SIZE_X/4 - 200;
    static final int ADJUST = 150;
    public static final int COLUMNS = 20;
    
    private GridPane gridPane;
    private Color penColor;
    private ImageView turtle;
    private Image turtleIm;
    private TextArea commandLine;
    private Button enter;
    private Button clear;
    private CanvasGenerator canvas;
    private Button imageChanger;
    private ListViewNamer commandHistory;
    private ListViewNamer currCommands;
    private ListViewNamer currVariables;
    private ComboBox<String> languageChooser;
    private ColorPicker penColorPicker;
    private ColorPicker backgroundColorPicker;
    private Button help;
    private ImageView turtleInvis;

    
    public SLogoScene(Scene scene, ResourceBundle resource) throws Exception{
        super(scene, resource, SIZE_Y, SIZE_X);
        Controller control=new Controller();
        penColor = Color.BLACK;
        String path = System.getProperty("user.dir");
        turtle = new ImageView(new File(path + "/src/resources.view/Turtle.png").toURI().toString());
        turtleInvis = new ImageView(turtle.getImage());
        turtleIm = turtle.getImage();
        commandLine = new TextArea();
        commandLine.setMaxHeight(30);
        canvas = new CanvasGenerator();
        languageChooser = new ComboBox<String>();
        help = new Button("Help");
        control.setUp();
        initControls();
        setScene();
    }
    public void setScene() throws Exception{
        DisplayGenerator dg = new DisplayGenerator();
        dg.setGridPane(COLUMNS);
        gridPane = dg.setScene(makeToolBar(), addListViews(), commandLine,
                               turtle, canvas, languageChooser,
                               makeButtons());
        myScene = new Scene(gridPane, SIZE_X,SIZE_Y);
    }
    private List<Control> makeToolBar(){
        List<Control> ctrls = new ArrayList<Control>();
        ctrls.add(imageChanger);
        ctrls.add(backgroundColorPicker);
        ctrls.add(penColorPicker);
        return ctrls;
    }
    
    private List<ListViewNamer> addListViews(){
        List<ListViewNamer> ctrls = new ArrayList<ListViewNamer>();
        ctrls.add(currCommands);
        ctrls.add(currVariables);
        ctrls.add(commandHistory);
        return ctrls;
    }
    
    private List<Button> makeButtons(){
        List<Button> ctrls = new ArrayList<Button>();
        ctrls.add(enter);
        ctrls.add(help);
        ctrls.add(clear);
        return ctrls;
    }
    
    public Button getEnter(){
        return enter;
    }
    public Button getClear(){
        return clear;
    }
    public void changeBackgroundColor(Color color){
        canvas.changeBackgroundColor(color);
    }
    public ColorPicker getBackgroundPicker(){
        return backgroundColorPicker;
    }
    public Button getImagePicker(){
        return imageChanger;
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
        turtleIm = new Image(new File(pic).toURI().toString());
        turtle.setImage(turtleIm);
        turtle.setFitWidth(40);
        turtle.setFitHeight(40);
        turtle.setPreserveRatio(true);
        turtle.setSmooth(true);
        turtle.setCache(true);
    }
    public ComboBox<String> getLanguageChooser(){
        return languageChooser;
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



    public void drawTurtle(double x, double y){
        if(x < CanvasGenerator.CANVAS_X/2 && x > -CanvasGenerator.CANVAS_X / 2 && y < CanvasGenerator.CANVAS_Y/2 && y > -CanvasGenerator.CANVAS_Y/2) {
            turtle.setTranslateX(canvasX(x));
            turtle.setTranslateY(canvasY(y));
        }
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
    private void initControls(){
        imageChanger = new Button("Change Image");
        commandHistory = new ListViewNamer("Command History");
        currCommands = new ListViewNamer("Current Commands");
        currVariables = new ListViewNamer("Current Variables");
        languageChooser = new ComboBox<String>();
        penColorPicker = new ColorPicker();
        backgroundColorPicker = new ColorPicker();
        backgroundColorPicker.setPromptText("Background Color");
        penColorPicker.setPromptText("Pen Color");
        enter = new Button("Enter");
        clear = new Button("Clear");
        help = new Button("Help");
    }
    private double canvasX(double x){
        return CanvasGenerator.CANVAS_X/2 + x;
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
