package View;

import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class ImageChanger extends ButtonGenerator{
    public Control create(){
        return new ComboBox();//possibly make a drop down menu for choosing image from a directory
    }
    public void execute(){

    }
}
