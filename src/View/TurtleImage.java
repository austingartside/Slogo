package View;

import java.io.File;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TurtleImage {

    public static final int ADJUST = 150;
    
    private ImageView turtle;
    private Image turtleIm;
    
    public TurtleImage(){
        String path = System.getProperty("user.dir");
        turtle = new ImageView(new File(path + "/src/resources.view/Turtle.png").toURI().toString());
        turtleIm = turtle.getImage();
        addImage(turtle);
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
    private void addImage(ImageView turtle){
        turtle.setFitWidth(40);
        turtle.setFitHeight(40);
        //turtle.setTranslateX(CanvasGenerator.CANVAS_X/2 - turtle.getFitWidth()/2);
        //turtle.setTranslateY(CanvasGenerator.CANVAS_Y/2 + ADJUST - turtle.getFitHeight()/2);
        centerImage(turtle);
        turtle.setPreserveRatio(true);
        turtle.setSmooth(true);
        turtle.setCache(true);
    }
    public void rotateTurtle(double angle){
        turtle.setRotate(angle);
    }
    public void makeTurtleInvisible(){
        turtleIm = turtle.getImage();
        turtle.setImage(null);
    }
    //TODO change colors later
    public void makeTurtleVisible(){
        turtle.setImage(turtleIm);
    }
    public ImageView getTurtle(){
        return turtle;
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
}
