package screens;

import java.util.ResourceBundle;
import javafx.scene.Group;
import javafx.scene.Scene;

public abstract class ActionScene {
    private Group myRoot;
    private ResourceBundle myResources;
    private Scene myScene;
    
    public ActionScene(Scene scene, ResourceBundle resource, int height, int width){
        myRoot = new Group();
        myResources = resource;
        myScene = scene;
    }
    
    public Group getRoot(){
        return myRoot;
    }
    
    public void setRoot(Group r){
        myRoot = r;
    }
}
