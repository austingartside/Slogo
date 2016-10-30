package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class FileControl {
    
    private Button save;
    private Button load;
    private HBox fileControl;
    
    public FileControl(){
        
        save = new Button("Save");
        load = new Button("Load");
        
        fileControl = new HBox();
        
        fileControl.getChildren().addAll(save,load);
        fileControl.setSpacing(10);
    }
    
    public Node getView(){
        return fileControl;
    }
    public void setSaveAction(EventHandler<ActionEvent> a){
        save.setOnAction(a);
    }
    public void setLoadAction(EventHandler<ActionEvent> a){
        load.setOnAction(a);
    }

}
