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
    public static final int CANVAS_X = 600;
    public static final int CANVAS_Y = 400;
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
    public Canvas createCanvas(){
        gc.setFill(DEFAULT);
        gc.fillRect(0, 0, CANVAS_X, CANVAS_Y);
        return canvas;
    }
    public void changeBackgroundColor(Color color){
        gc.setFill(color);
        gc.fillRect(0, 0, CANVAS_X, CANVAS_Y);
    }
    public void clear(){
        gc.setFill(DEFAULT);
        gc.fillRect(0, 0, CANVAS_X, CANVAS_Y);
        //gc.clearRect(DisplayGenerator.ALIGN, CANVAS_OFFSET, CANVAS_X, CANVAS_Y);
    }
}
