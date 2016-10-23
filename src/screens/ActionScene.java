package screens;

import java.util.ResourceBundle;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class ActionScene {
    protected ResourceBundle myResources;
    protected Scene myScene;
    protected int height;
    protected int width;
    
    public ActionScene(Scene scene, ResourceBundle resource, int h, int w){
        myResources = resource;
        height = h;
        width = w;
        myScene = scene;
    }
    
    private void showError (String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(message);
        alert.setContentText(myResources.getString(message));
        alert.showAndWait();
    }
}
