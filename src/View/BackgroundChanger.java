package View;

import javafx.scene.Group;


/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class BackgroundChanger extends ButtonGenerator{
    public void create(Group g){
        setAttributes("Background Color");
        getList().getItems().addAll(getChoices());
        g.getChildren().add(getList());
    }
    public void execute(){

    }
}
