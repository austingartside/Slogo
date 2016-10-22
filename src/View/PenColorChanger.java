package View;
import javafx.scene.control.ComboBox;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */

public class PenColorChanger extends ButtonGenerator{
    public ComboBox<Object> create(){
        setAttributes("Change Pen Color");
        getList().getItems().addAll(getChoices());
        return getList();
    }
    public void execute(){

    }
}
