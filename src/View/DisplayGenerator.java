package View;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by Bill Xiong on 10/19/16.
 * Generates and updates the display. Should not interact with backend
 */
public class DisplayGenerator {

    public static final double SIZE_X = 1200;
    public static final double SIZE_Y = 800;
    static final double ALIGN = SIZE_X/4 - 200;

    private Scene scene;
    private Group group;
    private TextField commandLine;
    private Button enter;


    public DisplayGenerator(){
        commandLine = new TextField();
        enter = new Button("Enter");
        group = new Group();
        scene = new Scene(group, SIZE_X, SIZE_Y);
    }

    /**
     * This method adds all necessary components to the front end.
     * TODO add a turtle image here. Will do this once Gunhan/Austin makes getter for image.
     */
    public void setScene(){
        addCommandInput();
        addCanvas();
        addButtons();
    }

    /**
     * Use this method to add an event handler to the button that will process text and send
     * to the backend.
     * @return the submit button to submit the command to the backend
     */
    public Button getEnter(){
        return enter;
    }
    public Scene getScene(){
        return scene;
    }
    private void addButtons(){
        ButtonGenerator b = new BackgroundChanger();
        b.create(group);
    }
    private void addCommandInput(){
        Label label1 = new Label("Command:");
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, commandLine, enter);
        hb.setSpacing(10);
        hb.setLayoutY(SIZE_Y-150);
        hb.setLayoutX(ALIGN);
        group.getChildren().add(hb);
    }
    private void addCanvas(){
        CanvasGenerator generator = new CanvasGenerator();
        generator.createCanvas(group);
    }
    public String getCommand(){
        return commandLine.getText();
    }
}
