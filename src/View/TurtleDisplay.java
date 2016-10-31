package View;

import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class TurtleDisplay {

    public enum LineType{
        DASH, DOTTED, SOLID
    }
    public enum PenStatus{
        PENDOWN, PENUP
    }
    private TurtleImage turtleImage;
    private CanvasGenerator backgroundCanvas;
    private CanvasGenerator lineCanvas;
    private StackPane stackPane;
    private Color penColor;
    private double thickness;
    private final double NUM_DASH = 5.0;
    private double dashes;
    private PenStatus status;
    
    public TurtleDisplay(){
        stackPane = new StackPane();
        backgroundCanvas = new CanvasGenerator();
        lineCanvas = new CanvasGenerator();
        turtleImage = new TurtleImage();
        backgroundCanvas.fillCanvas(Color.BLUE);
        penColor = Color.BLACK;
        status = PenStatus.PENDOWN;
        thickness = 1.0;
        dashes = 0;
        
        stackPane.getChildren().addAll(backgroundCanvas.getView(),lineCanvas.getView(),turtleImage.getView());
    }
    
    public void changeBackgroundColor(Color color){
        backgroundCanvas.changeBackgroundColor(color);
    }
   
    public void drawLine(double xPrev, double yPrev, double x, double y){
        if(status == PenStatus.PENDOWN) {
            GraphicsContext gc = lineCanvas.getContext();
            gc.setStroke(penColor);
            gc.setLineWidth(thickness);
            gc.setLineDashes(dashes);
            gc.strokeLine(canvasLineX(xPrev), canvasLineY(yPrev), canvasLineX(x), canvasLineY(y));
        }
    }
    public void setPenStatus(PenStatus status){
        this.status = status;
    }
    public void setDash(LineType line){
        dashes = (line == LineType.SOLID) ? 0 : NUM_DASH;
    }
    public void setThickness(double v){
        thickness = v;
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
