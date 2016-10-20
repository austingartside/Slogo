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
    private final int CANVAS_X = 800;
    private final int CANVAS_Y = 600;
    private Canvas canvas;
    private GraphicsContext gc;

    public CanvasGenerator(){
        canvas = new Canvas(CANVAS_X, CANVAS_Y);
        gc = canvas.getGraphicsContext2D();
    }
    public Canvas getCanvas(){
        return canvas;
    }
    public void createCanvas(Group group){
        gc.setFill(Color.GREENYELLOW);
        gc.fillRect(DisplayGenerator.ALIGN, 75, CANVAS_X, CANVAS_Y);
        group.getChildren().add(canvas);
    }
    public void changeBackgroundColor(Color color){
        gc.setFill(color);
        gc.fillRect(DisplayGenerator.ALIGN, 75, CANVAS_X, CANVAS_Y);

    }

}
