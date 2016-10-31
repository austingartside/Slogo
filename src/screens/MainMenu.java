package screens;

import View.DisplayGenerator;
import javafx.scene.control.Button;
import java.io.File;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;

public class MainMenu {
    public static SLogoScene slogoScene;
    private Group myRoot;
    private Scene myScene;
    private ResourceBundle myResources;
    private ImageView myLogo;
    private SLogoScene myActionScene;
    private Controller myController;
    private Stage stage;
    private int width;
    private int height;
    
    public Scene init(Stage s, int w, int h, ResourceBundle resources){
        //myController=control;
        width = w;
        height = h;
        stage = s;
    	myResources = resources;
        myRoot = new Group();
        VBox vb = new VBox();
        myScene = new Scene(myRoot, width, height);
        
        //Image logo = new Image(myResources.getString("LogoImage"));
        Image logo = new Image("resources.view/SLogoLogo.jpg");
        myLogo = new ImageView(logo);
        myLogo.setFitHeight(height);
        myLogo.setFitWidth(width);
        
        vb.getChildren().addAll(setupStart(),setupLoad());
        vb.setSpacing(10);
        vb.setLayoutY(4*height/5);
        vb.setLayoutX(width/2-setupStart().getPrefWidth()/2);
        myRoot.getChildren().addAll(myLogo,vb);
        vb.setAlignment(Pos.CENTER);
        return myScene;
    }
    
    private Button setupStart(){
        Button startProject = new Button("Start Animation");
        //startProject.setLayoutX(width/2-startProject.getWidth()/2);
        startProject.setPrefWidth(width/2);

        startProject.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent ae){
                myActionScene = new SLogoScene(myScene, myResources);
                Controller control =new Controller();
                control.setUp(stage,myResources,myActionScene);
            }
        });
        
        return startProject;
    }
    private Button setupLoad(){
        //Button startProject = new Button(myResources.getString("StartProject"));
        Button loadProject = new Button("Load Animation");
        //loadProject.setLayoutX(width/2-loadProject.getWidth()/2);
        loadProject.setPrefWidth(width/2);

        loadProject.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent ae){
                FileChooser chooser = new FileChooser();
                Stage mainStage = stage;
                File file = chooser.showOpenDialog(mainStage);
                myActionScene = new SLogoScene(myScene, myResources,file);
                Controller control =new Controller();
                control.setUp(stage,myResources,myActionScene);
            }
        });
        
        return loadProject;
    }
    
}
