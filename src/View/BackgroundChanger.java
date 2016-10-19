package View;

import javafx.scene.Group;
import java.util.List;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class BackgroundChanger extends ButtonGenerator{
    public void create(Group g, List list){
        setAttributes("Background Color");
        getList().getItems().addAll(list);
        g.getChildren().add(getList());
    }
    public void execute(){

    }
}
