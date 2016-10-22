package View;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */

public class PenColorChanger extends ButtonGenerator{
    private Button button;
    public PenColorChanger(){
        button = new Button("Change Pen Color");
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
