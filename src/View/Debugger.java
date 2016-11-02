package View;

import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Created by billxiong24 on 10/30/16.
 * For undo and debugger (hopefully)
 */

public class Debugger {
    private Button undo;
    private HBox debugger;
    private Stack<TurtleDisplay> displayStack;
    public Debugger() {
        undo = new Button("Undo");
        debugger = new HBox();
        debugger.getChildren().addAll(undo);
        displayStack = new Stack<>();
    }
    public void setUndoAction(EventHandler<ActionEvent> a){
        undo.setOnAction(a);
    }
    public Node getView(){
        return debugger;
    }
    
    public void push(TurtleDisplay td){
        displayStack.push(td);
    }
    public TurtleDisplay pop(){
        return displayStack.pop();
    }
    
}
