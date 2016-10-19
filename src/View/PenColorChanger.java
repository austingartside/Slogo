package View;

import javafx.scene.Group;

import java.util.List;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */

public class PenColorChanger extends ButtonGenerator{
    public void create(Group g, List list){
        setAttributes("Change Pen Color");
        getList().getItems().addAll(list);
        g.getChildren().add(getList());
    }
    public void execute(){

    }
}
