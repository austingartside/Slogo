package View;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * Created by billxiong24 on 11/1/16.
 * Super abstract class for CommandHistory, CurrentCommands, CurrentVariables, and CurrentState.
 */
public abstract class CurrentInfo {
    private ListView<String> currInfo;

    public CurrentInfo(){
        currInfo = new ListView<>();
    }
    public ListView<String> getCurrInfo(){
        return currInfo;
    }
    public void addItem(String s){
        currInfo.getItems().add(s);
    }
    public Node getView(){
        return currInfo;
    }
    public void setOnAction(EventHandler<MouseEvent> a){
        currInfo.setOnMouseClicked(a);
    }

    public String getCommand(){
        return currInfo.getSelectionModel().getSelectedItem();
    }

    public void clear(){
        currInfo.getItems().clear();
    }
}
