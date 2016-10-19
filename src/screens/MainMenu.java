package screens;

import javafx.scene.control.Button;
import java.util.ResourceBundle;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class MainMenu {
    private GridPane myRoot;
    private Scene myScene;
    private ResourceBundle myResources;
    private ImageView myLogo;
    private ActionScene myActionScene;
    
    public Scene init(int width, int height, ResourceBundle resources){
        myResources = resources;
        myRoot = new GridPane();
        myRoot.setAlignment(Pos.CENTER);
        myRoot.setHgap(10);
        myRoot.setVgap(10);
        myRoot.setPadding(new Insets(25, 25, 25, 25));
        
        myScene = new Scene(myRoot, width, height);
        
        Image logo = new Image(getClass().getClassLoader().getResourceAsStream(myResources.getString("LogoImage")));
        myLogo = new ImageView(logo);
        myLogo.setFitHeight(height);
        myLogo.setFitWidth(width);
        
        Button startProject = new Button(myResources.getString("StartProject"));
        
        startProject.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(final ActionEvent ae){
                myActionScene = new LogoScene(myScene, myResources, height, width);
                myScene.setRoot(myActionScene.getRoot());
            }
        });
        
        
        myRoot.add(startProject, 3, 1);
        GridPane.setHalignment(startProject, HPos.CENTER);
        
        return myScene;
    }
    
}
