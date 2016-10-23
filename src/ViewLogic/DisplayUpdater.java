package ViewLogic;
import View.CanvasGenerator;
import View.DisplayGenerator;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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
    private String language;
    private DisplayGenerator generator;
    public DisplayUpdater(DisplayGenerator g){
        generator = g;
        language = "English";
    }
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
    public String getLanguage(){
        return language;
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
    public void setVisible(boolean visible){
        if(!visible)
            generator.makeTurtleInvisible();
        else{
            generator.makeTurtleVisible();
        }
    }

    public void setOrientation(double angle){
        generator.rotateTurtle(angle);
    }
    public void resetToHome(){
        generator.drawTurtle(0, 0);
    }
    public void clear(){
        generator.clear();
    }
    public void parse(String str){}

    private void addEnterHandler(){
        generator.getEnter().setOnAction((actionEvent -> {
            //call parser to parse stuff
            //use generator.getCommand() to get String input
            updateHistory(generator.getCommand());
            generator.setText("");
        }));
    }
    private void addHandlers(){
        generator.getBackgroundPicker().setOnAction((event) ->{
            generator.changeBackgroundColor(generator.getBackgroundPicker().getValue());
        });
        generator.getCommandHistory().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });
        generator.getCurrCommands().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });
        generator.getCurrVariables().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });
        generator.getLanguageChooser().setOnAction((event) -> {
                    language = (String) generator.getLanguageChooser().getSelectionModel().getSelectedItem();
        });

        generator.getCommandHistory().setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent m){
                String command = generator.getCommandHistory().getSelectionModel().getSelectedItem();
                generator.setText(command);
            }
        });

        generator.getPenColorPicker().setOnAction((event) ->{
            Color c = generator.getPenColorPicker().getValue();
            //generator.setPenColor(c);
        });
    }
}
