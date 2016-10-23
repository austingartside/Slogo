package ViewLogic;
import View.DisplayGenerator;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Iterator;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class DisplayUpdater implements ViewToModelInterface{
    private DisplayGenerator generator;

    public DisplayUpdater(DisplayGenerator g){
        generator = g;
    }
    public void setUp(){
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
            //use generator.getCommand() to get String input
            updateHistory(generator.getCommand());
            generator.setText("");
        }));
    }

    //event handlers for listview, combobox, etc.
    private void addHandlers(){
        generator.getBackgroundPicker().setOnAction((event) ->{
            generator.changeBackgroundColor(generator.getBackgroundPicker().getValue());
        });
        generator.getImagePicker().setOnAction((event) ->{
            FileChooser chooser = new FileChooser();
            Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            File imageFile = chooser.showOpenDialog(mainStage);
            generator.changeTurtleImage(imageFile.toString());
            /*try{
                if(imageFile.toString() != null){
                    generator.changeTurtleImage(imageFile.toString());
                }
            }catch(NullPointerException n){
                //
            }*/

        });
        generator.getCommandHistory().setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent m){
                String command = generator.getCommandHistory().getSelectionModel().getSelectedItem();
                generator.setText(command);
            }
        });
        generator.getCurrCommands().setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent m){
                //TODO use the map to map the method to text
                String command = generator.getCurrCommands().getSelectionModel().getSelectedItem();
                generator.setText(command);
            }
        });
        generator.getCurrVariables().setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent m){
                
            }
        });
        generator.getLanguageChooser().setOnAction((event) ->{

        });

        generator.getPenColorPicker().setOnAction((event) ->{
            Color c = generator.getPenColorPicker().getValue();
            generator.setPenColor(c);
        });
    }


}
