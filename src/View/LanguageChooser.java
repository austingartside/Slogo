package View;
import javafx.scene.control.ComboBox;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class LanguageChooser extends ButtonGenerator{
    private ComboBox<Object> cBox;
    public LanguageChooser(){
        cBox = new ComboBox<Object>();
    } 
    public ComboBox<Object> create(){
        cBox.setPromptText("Change Language");
        control = cBox;
        return cBox;
    }
    
    public void execute(){

    }
    public void addToList(Object o){
        cBox.getItems().add(o);
    }
    public ComboBox<Object> getBox(){
        return cBox;
    }
}
