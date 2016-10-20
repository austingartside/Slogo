package View;

import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class LanguageChooser extends ButtonGenerator{
    public void create(Group g){
        setAttributes("Change Language");
        getList().getItems().addAll(getChoices());
        g.getChildren().add(getList());
    }
    public void execute(){

    }
}
