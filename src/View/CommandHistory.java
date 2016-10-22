package View;
import javafx.scene.control.ComboBox;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class CommandHistory extends ButtonGenerator{
    @Override
    public ComboBox<Object> create(){
        setAttributes("Command History");
        getList().getItems().addAll(getChoices());
        return getList();
    }

    public void execute(){

    }
}
