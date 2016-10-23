package View;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class ImageChanger extends ButtonGenerator{
    private Button button;
    public ImageChanger(){
        button = new Button("Change Image");
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
