package View;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class TurtleAnimation extends TurtleImage {
    private int milliseconds;
    private SequentialTransition a;
    private boolean isVis;
    
    public TurtleAnimation(){
        milliseconds = 1000;
        a = new SequentialTransition(getTurtle());
        isVis = true;
    }
    @Override
    public void drawTurtle(double xPrev,double yPrev,double x, double y) {
        getTurtle().setImage(getTurtleImage());
        Path path = new Path();
        path.getElements().addAll(new MoveTo(xPrev+getTurtle().getFitWidth(),yPrev+getTurtle().getFitHeight()), new LineTo(x+getTurtle().getFitWidth(),y+getTurtle().getFitHeight()));
        PathTransition pt = new PathTransition(Duration.millis(milliseconds), path, getTurtle());
        a = new SequentialTransition(getTurtle(),pt);
        a.play();
        getTurtle().setTranslateX(x);//canvasX(x)
        getTurtle().setTranslateY(y);//canvasY(y)
        if(x < CanvasGenerator.CANVAS_X/2 && x > -CanvasGenerator.CANVAS_X / 2 && y < CanvasGenerator.CANVAS_Y/2 && y > -CanvasGenerator.CANVAS_Y/2) {
            getTurtle().setVisible(true);
        }else{
            getTurtle().setVisible(false);
        }
    }
    
    @Override
    public void rotateTurtle(double angle){
        RotateTransition rt = new RotateTransition(Duration.millis(milliseconds));
        rt.setByAngle(angle-getTurtle().getRotate());
        a = new SequentialTransition(getTurtle(), rt);
        a.play();
    }
    
    @Override
    public void makeTurtleInvisible(){
        if(isVis){
            FadeTransition ft = new FadeTransition(Duration.millis(milliseconds));
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            a = new SequentialTransition(getTurtle(),ft);
            a.play();
        }
    }
    
    @Override
    public void makeTurtleVisible(){
        if(!isVis){
            FadeTransition ft = new FadeTransition(Duration.millis(milliseconds));
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            a = new SequentialTransition(getTurtle(),ft);
            a.play();
        }
    }
    
    @Override
    public void setMilliseconds(int ms){
        milliseconds = ms;
    }
    
}
