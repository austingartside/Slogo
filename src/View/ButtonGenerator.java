package View;

import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bill Xiong on 10/19/16.
 * Adds all the buttons to the page.
 */
public abstract class ButtonGenerator{
    protected Control control;
    private List<Object> choices;
    public ButtonGenerator(){
        choices = new ArrayList<>();
    }
    protected List<Object> getList(){
        return choices;
    }
    protected abstract Control create();
    protected abstract void execute();
}
