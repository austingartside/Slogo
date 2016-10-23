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
    private Button button;
    public BackgroundChanger(){
        button = new Button("Background Color");
    }
    @Override
    public Button create(){
        control = button;
        return button;
    }
    public void execute(){

    }
    public Button getButton(){
        return button;
    }
}
