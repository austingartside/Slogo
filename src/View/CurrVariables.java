package View;

import javafx.scene.Group;

import java.util.List;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class CurrVariables extends ButtonGenerator{

    public void create(Group g) {
        setAttributes("Current Variables");
        getList().getItems().addAll(getChoices());
        g.getChildren().add(getList());
    }
    public void execute(){

    }
}
