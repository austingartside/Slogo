package View;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.paint.Color;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class BackgroundChanger extends ButtonGenerator{
    private ComboBox<Color> colors;
    public BackgroundChanger(){
        colors = new ComboBox<>();
    }
    public Control create(){
        colors.setPromptText("Change Background Color");
        colors.setLayoutX(DisplayGenerator.SIZE_X - ButtonGenerator.OFFSET_X);
        colors.setLayoutY(ButtonGenerator.OFFSET_Y);
        colors.getItems().addAll(Color.BLACK, Color.BLUE, Color.GREEN, Color.RED);
        return colors;
    }
    public void execute(){

    }
}
