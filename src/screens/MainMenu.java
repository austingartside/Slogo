package screens;

import View.DisplayGenerator;
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
import javafx.stage.Stage;
import model.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;

public class MainMenu {
    public static final DisplayGenerator displayGenerator = new DisplayGenerator();
    private Group myRoot;
    private Scene myScene;
    private ResourceBundle myResources;
    private ImageView myLogo;
    private SLogoScene myActionScene;
    
    public Scene init(Stage stage, int width, int height, ResourceBundle resources){
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
        
        
        startProject.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent ae){
                myActionScene = new SLogoScene(myScene, myResources, height, width);
                stage.setScene(myActionScene.getUpdater().getGeneratorScene());
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
