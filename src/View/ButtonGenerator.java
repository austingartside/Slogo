package View;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;

/**
 * Created by Bill Xiong on 10/19/16.
 * Adds all the buttons to the page.
 */
public abstract class ButtonGenerator{
    protected static final int OFFSET_X = 300;
    protected static final int OFFSET_Y = 100;
    private ComboBox<Object> list;
    public ButtonGenerator(){
        list = new ComboBox<>();
    }
    protected ComboBox<Object> getList(){
        return list;
    }
    protected abstract Control create();
    protected abstract void execute();
}
