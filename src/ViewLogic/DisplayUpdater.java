package ViewLogic;
import View.DisplayGenerator;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import java.util.Iterator;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class DisplayUpdater implements ViewToModelInterface{
    //private DisplayGenerator generator;
    private static final DisplayGenerator generator = new DisplayGenerator();

    public void setUp(){
        generator.setScene();
        addHandlers();
        addEnterHandler();
    }
    public Scene getGeneratorScene(){
        return generator.getScene();
    }

    public void setCoordinate(boolean penDown, double xPrev, double yPrev, double x, double y){
        generator.drawTurtle(x, y);
        if(penDown){
            generator.drawLine(xPrev, yPrev, x, y);
        }
    }
    public void updateHistory(String object){
        generator.getCommandHistory().getItems().add(object);
    }
    public void updateCurrCommands(String object){
        generator.getCurrCommands().getItems().add(object);
    }
    public void updateCurrVariables(String object){
        generator.getCurrVariables().getItems().add(object);
    }

    public String getCurrLanguage(){
        return (String) generator.getLanguageChooser().getSelectionModel().getSelectedItem();
    }
    public void setVisible(){

    }
    public void setOrientation(double angle){
        generator.rotateTurtle(angle);
    }
    public void resetToHome(){
        generator.drawTurtle(0, 0);
    }
    public void clear(){
        generator.drawTurtle(0, 0);
        GridPane group = generator.getGridPane();
        ObservableList<Node> list = group.getChildren();
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Node n = (Node) iterator.next();
            if(n instanceof Line){
                iterator.remove();
            }
        }
    }
    //TODO ADD CALL TO PARSER HERE
    private void addEnterHandler(){
        generator.getEnter().setOnAction((actionEvent -> {
            //call parser to parse stuff
            //use generator.getInput() to get String input
        }));
    }
    private void addHandlers(){
        generator.getBackgroundPicker().setOnAction((event) ->{
            generator.changeBackgroundColor((Color) generator.getBackgroundPicker().getValue());
        });
        generator.getImagePicker().setOnAction((event) ->{
        });
        generator.getCommandHistory().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent m){
                
            }
        });
        generator.getCurrCommands().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent m){
                
            }
        });
        generator.getCurrVariables().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent m){
                
            }
        });
        generator.getLanguageChooser().setOnAction((event) ->{
        });
        generator.getPenColorPicker().setOnAction((event) ->{
            Color c = (Color) generator.getPenColorPicker().getValue();
            generator.setPenColor(c);
        });
    }


}
