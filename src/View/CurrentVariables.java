package View;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class CurrentVariables implements Placeable{
    
    private ListView<String> currVar;
    
    public CurrentVariables() {
        currVar = new ListView<String>();
    }
    
    public void addItem(String s){
        currVar.getItems().add(s);
    }
    
    public Node getView(){
        return currVar;
    }
    
    public void setOnAction(EventHandler<MouseEvent> a){
        currVar.setOnMouseClicked(a);
    }
    
    public String getVariable(){
        return currVar.getSelectionModel().getSelectedItem();
    }
    
    public void clear(){
        currVar.getItems().clear();
    }

}
