package ViewLogic;
import View.DisplayGenerator;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
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
            Color c = (Color) generator.getPenColorChanger().getSelectionModel().getSelectedItem();
            generator.drawLine(c, xPrev, yPrev, x, y);
        }
    }
    public void updateHistory(Object object){
        generator.getCommandHistory().getItems().add(object);
    }
    public void updateCurrCommands(Object object){
        generator.getCurrCommands().getItems().add(object);
    }
    public void updateCurrVariables(Object object){
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
        Group group = generator.getGroup();
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
        generator.getBackgroundChanger().setOnAction((event) ->{
            generator.changeBackgroundColor((Color) generator.getBackgroundChanger().getSelectionModel().getSelectedItem());
        });
        generator.getImageChanger().setOnAction((event) ->{
        });
        generator.getCommandHistory().setOnAction((event) ->{
        });
        generator.getCurrCommands().setOnAction((event) ->{
        });
        generator.getCurrVariables().setOnAction((event) ->{
        });
        generator.getLanguageChooser().setOnAction((event) ->{
        });
        generator.getPenColorChanger().setOnAction((event) ->{
        });
    }


}
