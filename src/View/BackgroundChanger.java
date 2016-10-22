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
    @Override
    public ComboBox<Object> create(){
        setAttributes("Background Color");
        getList().getItems().addAll(getChoices());
        return getList();
    }
    public void execute(){

    }
}
