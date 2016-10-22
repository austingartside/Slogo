package View;
import javafx.scene.control.ComboBox;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class ImageChanger extends ButtonGenerator{
    public ComboBox<Object> create(){
        setAttributes("Change Image");
        getList().getItems().addAll(getChoices());
        return getList();
    }
    public void execute(){

    }
}
