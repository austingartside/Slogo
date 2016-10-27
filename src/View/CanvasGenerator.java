package View;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Bill Xiong on 10/19/16.
 * Generates Canvas and all operations related to canvas
 */
public class CanvasGenerator {
    public static final int CANVAS_X = 600;
    public static final int CANVAS_Y = 400;
    public double boundMaxY,boundMaxX,boundMinY,boundMinX;
    private Canvas canvas;
    private GraphicsContext gc;
    private final Color DEFAULT = Color.BLUE;

    public GraphicsContext getContext(){
        return gc;
    }
    public CanvasGenerator(){
        canvas = new Canvas(CANVAS_X, CANVAS_Y);
        gc = canvas.getGraphicsContext2D();
    }
    public void fillCanvas(Color c){
        gc.setFill(DEFAULT);
        gc.fillRect(0, 0, CANVAS_X, CANVAS_Y);
    }
    public void changeBackgroundColor(Color color){
        gc.setFill(color);
        gc.fillRect(0, 0, CANVAS_X, CANVAS_Y);
    }
    public void clear(){
        gc.setFill(DEFAULT);
        gc.fillRect(0, 0, CANVAS_X, CANVAS_Y);
    }
    public void setBounds(double maxY,double minY,double maxX,double minX){
        boundMaxY = maxY;
        boundMaxX = maxX;
        boundMinY = minY;
        boundMinX = minX;
    }
    public Node getView(){
        return canvas;
    }
    public double getBoundMinX(){
        return boundMinX;
    }
    public double getBoundMinY(){
        return boundMinY;
    }
    public double getBoundMaxX(){
        return boundMaxX;
    }
    public double getBoundMaxY(){
        return boundMaxY;
    }
}
