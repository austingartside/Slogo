package View;

import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class LanguageChooser extends ButtonGenerator{
    public void create(Group g, List list){
        setAttributes("Change Language");
        getList().getItems().addAll(list);
        g.getChildren().add(getList());
    }
    public void execute(){

    }
}
