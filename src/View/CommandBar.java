package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CommandBar implements Actionable,Placeable{
    
    private Button enter;
    private Button clear;
    private Label command;
    private TextArea input;
    private HBox commandBar;
    
    
    public CommandBar(){
        command = new Label("Command:");
        input = new TextArea();
        input.setMaxHeight(30);
        
        VBox vb = setupButtons();
        
        commandBar = new HBox();
        commandBar.getChildren().addAll(command, input, vb);
        commandBar.setSpacing(10);
    }
    
    private VBox setupButtons(){
        VBox vb = new VBox();
        
        enter = new Button("enter");
        clear = new Button("clear");
        
        vb.getChildren().addAll(enter,clear);
        vb.setSpacing(10);
        
        return vb;
    }
    
    public void setEnterAction(EventHandler<ActionEvent> a){
        enter.setOnAction(a);
    }
    
    public void setText(String s){
        input.setText(s);
    }
    
    public String getText(){
        return input.getText();
    }
    
    public Node getView(){
        return commandBar;
    }
    
    public void setActions(){
        clear.setOnAction(actionEvent -> {
            setText("");
        });
    }
}
