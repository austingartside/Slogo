package View;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class TurtleAnimation extends TurtleImage {
    private int milliseconds;
    private SequentialTransition a;
    
    TurtleAnimation(){
        milliseconds = 1000;
        a = new SequentialTransition(getTurtle());
    }
    @Override
    public void drawTurtle(double x, double y) {
        System.out.println("HELLO");
        getTurtle().setImage(getTurtleImage());
        Path path = new Path();
        path.getElements().addAll(new MoveTo(getTurtle().getTranslateX()+getTurtle().getFitWidth(), getTurtle().getTranslateY()+getTurtle().getFitHeight()), new LineTo(x+getTurtle().getFitWidth(),y+getTurtle().getFitHeight()));
        PathTransition pt = new PathTransition(Duration.millis(milliseconds), path, getTurtle());
        a.getChildren().add(pt);
        if(x < CanvasGenerator.CANVAS_X/2 && x > -CanvasGenerator.CANVAS_X / 2 && y < CanvasGenerator.CANVAS_Y/2 && y > -CanvasGenerator.CANVAS_Y/2) {
            makeTurtleVisible();
        }else{
            makeTurtleInvisible();
        }
    }
    
    @Override
    public void rotateTurtle(double angle){
        RotateTransition rt = new RotateTransition(Duration.millis(milliseconds));
        rt.setByAngle(angle-getTurtle().getRotate());
        a.getChildren().add(rt);
    }
    
    @Override
    public void setMilliseconds(int ms){
        milliseconds = ms;
    }
    
    @Override
    public void animate(){
        a.play();
        a = new SequentialTransition(getTurtle());
    }
}
