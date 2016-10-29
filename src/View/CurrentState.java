package View;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * Created by billxiong24 on 10/29/16.
 * tracks current state of turtles and related states
 */
public class CurrentState{
    private final String XPOS = "X POSITION: ";
    private final String YPOS = "Y POSITION: ";
    private final String PENDOWN = "PEN DOWN: ";
    private final String PENCOLOR = "PEN COLOR: ";
    private final String BACKGROUND = "BACKGROUND: ";
    private final String HEADING = "HEADING: ";
    private ListView<String> currState;

    public CurrentState(){
        currState = new ListView<String>();
    }
    public void addCurrState(double id, double x, double y, double penDown, Color color, double heading){
        addItem("" + id);
        addItem(XPOS + x);
        addItem(YPOS + y);
        addItem(PENDOWN + penDown);
        addItem(PENCOLOR + color);
        addItem(HEADING + heading);
    }
    public void addItem(String s){
        currState.getItems().add(s);
    }

    public Node getView(){
        return currState;
    }

    public void setOnAction(EventHandler<MouseEvent> a){
        currState.setOnMouseClicked(a);
    }

    public String getVariable(){
        return currState.getSelectionModel().getSelectedItem();
    }

    public void clear(){
        currState.getItems().clear();
    }


}
