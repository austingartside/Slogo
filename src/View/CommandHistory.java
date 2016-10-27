package View;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class CommandHistory {
    
    private ListView<String> commHist;
    
    public CommandHistory(){
        commHist = new ListView<String>();
    }
    
    public void addItem(String s){
        commHist.getItems().add(s);
    }
    
    public Node getView(){
        return commHist;
    }
    
    public void setOnAction(EventHandler<MouseEvent> a){
        commHist.setOnMouseClicked(a);
    }
    
    public String getCommand(){
        return commHist.getSelectionModel().getSelectedItem();
    }
    
    public void clear(){
        commHist.getItems().clear();
    }

}
