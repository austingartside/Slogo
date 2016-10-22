package screens;

import javafx.scene.control.Button;
import java.util.ResourceBundle;
import ViewLogic.DisplayUpdater;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;

public class MainMenu {
    private Group myRoot;
    private Scene myScene;
    private ResourceBundle myResources;
    private ImageView myLogo;
    private ActionScene myActionScene;
    
    public Scene init(int width, int height, ResourceBundle resources){
        myResources = resources;
        myRoot = new Group();
        VBox vb = new VBox();
        myScene = new Scene(myRoot, width, height);
        //Image logo = new Image(myResources.getString("LogoImage"));
        Image logo = new Image("resources.view/SLogoLogo.jpg");
        myLogo = new ImageView(logo);
        myLogo.setFitHeight(height);
        myLogo.setFitWidth(width);
        
        //Button startProject = new Button(myResources.getString("StartProject"));
        Button startProject = new Button("Start Animation!");
        startProject.setLayoutX(width/2-startProject.getWidth()/2);
        startProject.setLayoutY(11*(height-startProject.getHeight())/12);
        startProject.setPrefWidth(width/2);

        DisplayUpdater display = new DisplayUpdater();
        display.setUp();
        Controller control=new Controller();
        control.setUp();
        
        startProject.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(final ActionEvent ae){
                myActionScene = new SLogoScene(myScene, myResources, height, width);
                myScene.setRoot(myActionScene.getRoot());
            }
        });
        vb.getChildren().add(startProject);
        vb.setSpacing(10);
        vb.setLayoutY(4*height/5);
        vb.setLayoutX(width/2-startProject.getPrefWidth()/2);
        myRoot.getChildren().addAll(myLogo,vb);
        return myScene;
    }
    
}
