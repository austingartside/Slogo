package ViewLogic;
import View.DisplayGenerator;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class DisplayUpdater {
    private DisplayGenerator generator;

    public DisplayUpdater(){
        generator = new DisplayGenerator();
    }
    public void setUp(){
        generator.setScene();
        addHandlers();
        addEnterHandler();
    }
    public Scene getGeneratorScene(){
        return generator.getScene();
    }

    public void updateTurtleLoc(boolean penDown, double xPrev, double yPrev, double x, double y){
        generator.drawTurtle(x, y);
        if(penDown){
            Color c = (Color) generator.getPenColorChanger().getSelectionModel().getSelectedItem();

            generator.drawLine(c, xPrev, yPrev, x, y);
        }
    }
    public void addToHistory(Object object){
        generator.getCommandHistory().getItems().add(object);
    }
    public void addToCurrCommands(Object object){
        generator.getCurrCommands().getItems().add(object);
    }
    public void addToCurrVariables(Object object){
        generator.getCurrVariables().getItems().add(object);
    }
    public String getCurrLanguage(){
        return (String) generator.getLanguageChooser().getSelectionModel().getSelectedItem();
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
