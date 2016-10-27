package View;

import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class TurtleDisplay {
    
    private TurtleImage turtleImage;
    private CanvasGenerator backgroundCanvas;
    private CanvasGenerator lineCanvas;
    private StackPane stackPane;
    private Color penColor;
    
    public TurtleDisplay(){
        penColor = Color.BLACK;
        stackPane = new StackPane();
        backgroundCanvas = new CanvasGenerator();
        lineCanvas = new CanvasGenerator();
        turtleImage = new TurtleImage();
        backgroundCanvas.fillCanvas(Color.BLUE);
        
        stackPane.getChildren().addAll(backgroundCanvas.getView(),lineCanvas.getView(),turtleImage.getView());
    }
    
    public void changeBackgroundColor(Color color){
        backgroundCanvas.changeBackgroundColor(color);
    }
   
    public void drawLine(double xPrev, double yPrev, double x, double y){
        GraphicsContext gc = lineCanvas.getContext();
        gc.moveTo(canvasLineX(xPrev), canvasLineY(yPrev));
        gc.setStroke(penColor);
        gc.lineTo(canvasLineX(x), canvasLineY(y));
        gc.stroke();
    }
    public void setPenColor(Color c){
        penColor = c;
    }
    public CanvasGenerator getBackgroundCanvas(){
        return backgroundCanvas;
    }
    public CanvasGenerator getLineCanvas(){
        return lineCanvas;
    }
    public void clear(){
        lineCanvas.clear();
    }
    public Node getView(){
        return stackPane;
    }
    public TurtleImage getTurtleImage(){
        return turtleImage;
    }
    private double canvasLineX(double x){
        return CanvasGenerator.CANVAS_X/2 + x;
    }
    private double canvasLineY(double y){
        return CanvasGenerator.CANVAS_Y/2 + y;
    }
    
}
