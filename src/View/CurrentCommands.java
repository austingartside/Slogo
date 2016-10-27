package View;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class CurrentCommands {
    private ListView<String> currComm;
    
    public CurrentCommands(){
        currComm = new ListView<String>();
    }
    
    public void addItem(String s){
        currComm.getItems().add(s);
    }
    
    public Node getView(){
        return currComm;
    }
    
    public void setOnAction(EventHandler<MouseEvent> a){
        currComm.setOnMouseClicked(a);
    }
    
    public String getCommand(){
        return currComm.getSelectionModel().getSelectedItem();
    }
    
    public void clear(){
        currComm.getItems().clear();
    }
}
