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
    private ComboBox<Object> list;
    private List<Object> choices;
    public ButtonGenerator(){
        choices = new ArrayList<>();
        list = new ComboBox<>();
    }
    protected ComboBox<Object> getList(){
        return list;
    }
    protected List<Object> getChoices(){
        return choices;
    }
    protected void setAttributes(String str){
        list.setPromptText(str);
    }
    protected abstract ComboBox<Object> create();
    protected abstract void execute();
}
