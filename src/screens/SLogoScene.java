package screens;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import View.CanvasGenerator;
import View.CommandBar;
import View.CommandHistory;
import View.CurrentCommands;
import View.CurrentVariables;
import View.DisplayGenerator;
import View.HelpTabs;
import View.SettingTools;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import model.Controller;

public class SLogoScene extends ActionScene{
    
    public static final int SIZE_X = 1200;
    public static final int SIZE_Y = 700;
    static final double ALIGN = SIZE_X/4 - 200;
    static final int ADJUST = 150;
    public static final int COLUMNS = 20;
    
    private String language;
    private GridPane gridPane;
    private Color penColor;
    private ImageView turtle;
    private Image turtleIm;
    private CanvasGenerator canvas;
    private CommandBar commandBar;
    private HelpTabs helpTabs;
    private SettingTools settingTools;
    private Button help;
    private ImageView turtleInvis;

    
    public SLogoScene(Scene scene, ResourceBundle resource) throws Exception{
        super(scene, resource, SIZE_Y, SIZE_X);
        Controller control=new Controller();
        penColor = Color.BLACK;
        commandBar = new CommandBar();
        String path = System.getProperty("user.dir");
        turtle = new ImageView(new File(path + "/src/resources.view/Turtle.png").toURI().toString());
        turtleInvis = new ImageView(turtle.getImage());
        turtleIm = turtle.getImage();
        canvas = new CanvasGenerator();
        help = new Button("Help");
        settingTools = new SettingTools();
        language = "English";
        help = new Button("Help");
        helpTabs = new HelpTabs();
        control.setUp();
        setScene();
    }
    
    public void setScene() throws Exception{
        DisplayGenerator dg = new DisplayGenerator();
        dg.setGridPane(COLUMNS);
        gridPane = dg.setScene(this);
        myScene = new Scene(gridPane, SIZE_X,SIZE_Y);
    }
    
    public void changeBackgroundColor(Color color){
        canvas.changeBackgroundColor(color);
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
    public void setPenColor(Color c){
        penColor = c;
    }
    public CommandBar getCommandBar(){
        return commandBar;
    }

    public void drawTurtle(double x, double y){
        if(x < CanvasGenerator.CANVAS_X/2 && x > -CanvasGenerator.CANVAS_X / 2 && y < CanvasGenerator.CANVAS_Y/2 && y > -CanvasGenerator.CANVAS_Y/2) {
            turtle.setTranslateX(canvasX(x)-turtle.getFitWidth()/2);
            turtle.setTranslateY(canvasY(y)-turtle.getFitHeight()/2);
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
    public ImageView getTurtle(){
        return turtle;
    }
    public CanvasGenerator getCanvas(){
        return canvas;
    }
    public void drawLine(double xPrev, double yPrev, double x, double y){
        GraphicsContext gc = canvas.getContext();
        gc.moveTo(canvasLineX(xPrev), canvasLineY(yPrev));
        gc.setStroke(penColor);
        gc.lineTo(canvasLineX(x), canvasLineY(y));
        gc.stroke();
    }
    public SettingTools getSettingTools(){
        return settingTools;
    }
    public Button getHelp(){
        return help;
    }
    public HelpTabs getHelpTabs(){
        return helpTabs;
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
