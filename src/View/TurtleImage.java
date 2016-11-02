package View;

import java.io.File;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TurtleImage implements Placeable{

    public static final int ADJUST = 150;
    
    private ImageView turtle;
    private Image turtleIm;
    private String turtleString;
    private final int FIT_WIDTH = 40;
    private final int FIT_HEIGHT = 40;
    
    public TurtleImage(){
        String path = System.getProperty("user.dir");
        turtleString = new File(path + "/src/resources.view/Turtle.png").toURI().toString();
        turtle = new ImageView(turtleString);
        turtleIm = turtle.getImage();
        addImage(turtle);
    }
    
    public void changeTurtleImage(String pic){
        turtleString = pic;
        turtleIm = new Image(turtleString);
        turtle.setImage(turtleIm);
        turtle.setFitWidth(FIT_WIDTH);
        turtle.setFitHeight(FIT_HEIGHT);
        turtle.setPreserveRatio(true);
        turtle.setSmooth(true);
        turtle.setCache(true);
    }
    public void drawTurtle(double x, double y){
        turtle.setImage(turtleIm);
        turtle.setTranslateX(x);//canvasX(x)
        turtle.setTranslateY(y);//canvasY(y)
        if(x < CanvasGenerator.CANVAS_X/2 && x > -CanvasGenerator.CANVAS_X / 2 && y < CanvasGenerator.CANVAS_Y/2 && y > -CanvasGenerator.CANVAS_Y/2) {
            makeTurtleVisible();
        }else{
            makeTurtleInvisible();
        }
    }
    public String getString(){
        return turtleString;
    }
    private void addImage(ImageView turtle){
        turtle.setFitWidth(FIT_WIDTH);
        turtle.setFitHeight(FIT_HEIGHT);
        centerImage(turtle);
        turtle.setPreserveRatio(true);
        turtle.setSmooth(true);
        turtle.setCache(true);
    }
    public void rotateTurtle(double angle){
        turtle.setRotate(angle);
    }
    public void makeTurtleInvisible(){
        turtle.setVisible(false);
    }
    //TODO change colors later
    public void makeTurtleVisible(){
        turtle.setVisible(true);
    }
    public Image getTurtleIm(){
        return turtleIm;
    }
    public ImageView getTurtle(){
        return turtle;
    }
    public Image getTurtleImage(){
        return turtleIm;
    }
    /*private double canvasX(double x){
        return CanvasGenerator.CANVAS_X/2 + x;
    }
    private double canvasY(double y){
        return CanvasGenerator.CANVAS_Y/2 + ADJUST + y;
    }*/
    private void centerImage(ImageView turtle) {
        turtle.setX(turtle.getFitWidth() / 2);
        turtle.setY(turtle.getFitHeight() / 2);
    }
    public Node getView(){
        return turtle;
    }

    public void setMilliseconds (int speed) {
        //nothing
    }
    public void animate () {
        //nothing
    }
}
