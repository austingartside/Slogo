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
    public void updateTurtleLoc(boolean penDown, double angle, double x, double y){
        generator.drawTurtle(angle, x, y);
    }
    public void addHistory(Object object){
        generator.addToHistory(object);
    }
    public void addCurrCommands(Object object){
        generator.addToCurrCommands(object);
    }
    public void addCurrVariables(Object object){
        generator.addToCurrVariables(object);
    }

    public String getCurrLanguage() {
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
