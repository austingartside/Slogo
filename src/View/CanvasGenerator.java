package View;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Bill Xiong on 10/19/16.
 * Generates Canvas and all operations related to canvas
 */
public class CanvasGenerator {
    public static final int CANVAS_X = 800;
    public static final int CANVAS_Y = 600;
    public static final int CANVAS_OFFSET = 75;
    private Canvas canvas;
    private GraphicsContext gc;

    public CanvasGenerator(){
        canvas = new Canvas(CANVAS_X, CANVAS_Y);
        gc = canvas.getGraphicsContext2D();
    }
    public GraphicsContext getGraphicsContext(){
        return gc;
    }
    public void createCanvas(Group group){
        gc.setFill(Color.GREENYELLOW);
        gc.fillRect(DisplayGenerator.ALIGN, CANVAS_OFFSET, CANVAS_X, CANVAS_Y);
        group.getChildren().add(canvas);
    }
    public void changeBackgroundColor(Color color){
        gc.setFill(color);
        gc.fillRect(DisplayGenerator.ALIGN, CANVAS_OFFSET, CANVAS_X, CANVAS_Y);
    }
    public void clear(){
        gc.setFill(Color.GREENYELLOW);
        gc.fillRect(DisplayGenerator.ALIGN, CANVAS_OFFSET, CANVAS_X, CANVAS_Y);
        //gc.clearRect(DisplayGenerator.ALIGN, CANVAS_OFFSET, CANVAS_X, CANVAS_Y);
    }
    public void addTurtle(){
    }
}
