package View;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class FileControl implements Placeable{
    
    private Button save;
    private Button load;
    private Button workspace;
    private HBox fileControl;
    
    public FileControl(){
        
        save = new Button("Save");
        load = new Button("Load");
        workspace = new Button("New Workspace");
        fileControl = new HBox();
        
        fileControl.getChildren().addAll(save,load, workspace);
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
    public void setWorkspaceAction(EventHandler<ActionEvent> a){
        workspace.setOnAction(a);
    }
}
