package screens;

import java.util.ResourceBundle;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class ActionScene {
    protected Group myRoot;
    protected ResourceBundle myResources;
    protected Scene myScene;
    
    public ActionScene(Scene scene, ResourceBundle resource, int height, int width){
        myRoot = new Group();
        myResources = resource;
        myScene = scene;
    }
    
    public Scene getScene(){
        return myScene;
    }
    public Group getRoot(){
        return myRoot;
    }
    
    public void setRoot(Group r){
        myRoot = r;
    }
    
    public void showError (String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(message);
        alert.setContentText(myResources.getString(message));
        alert.showAndWait();
    }
}
