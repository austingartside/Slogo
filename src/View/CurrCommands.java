package View;
import javafx.scene.control.ComboBox;
/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class CurrCommands extends ButtonGenerator{
    public ComboBox<Object> create(){
        setAttributes("Current Commands");
        getList().getItems().addAll(getChoices());
        return getList();
    }

    public void execute(){

    }
}
