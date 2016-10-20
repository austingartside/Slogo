package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.util.*;

/**
 * Created by Bill Xiong on 10/19/16.
 * Generates and updates the display. Should not interact with backend
 */
public class DisplayGenerator {

    public static final double SIZE_X = 1200;
    public static final double SIZE_Y = 800;
    static final double ALIGN_X = SIZE_X/20;
    static final double ALIGN_Y = SIZE_Y/20;

    private GridPane root;
    private Scene scene;
    private TextField commandLine;
    private Button enter;
    private Button help;
    private Canvas turtleCanvas;
    private Canvas backgroundCanvas;


    public DisplayGenerator(){
        commandLine = new TextField();
        enter = new Button("Enter");
        help = new Button("Help");
        root = new GridPane();
        root.setPadding(new Insets(20,20,20,20));
        root.setVgap(10);
        root.setHgap(10);
        root.setAlignment(Pos.CENTER);
        scene = new Scene(root, SIZE_X, SIZE_Y);
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
    private List<Control> addButtons(){
        List<Control> controls = new ArrayList<Control>();
        ButtonGenerator b = new BackgroundChanger();
        controls.add(b.create());
        return controls;
    }
    public ToolBar addToolBar(){
        ToolBar tb = new ToolBar();
        List<Control> controls = addButtons();
        tb.getItems().addAll(controls);
        root.add(tb, 0, 0, 3, 1);
        return tb;
    }
    public TextField addCommandInput(){
        commandLine.setPromptText("Command");
        root.add(commandLine,0,9,2,1);
        root.add(enter, 2, 9);
        return commandLine;
    }
    public Canvas addCanvas(){
        CanvasGenerator generator = new CanvasGenerator();
        Canvas newCanvas = generator.createCanvas();
        root.add(newCanvas,0,1,3,8);
        return newCanvas;
    }
    public String getCommand(){
        return commandLine.getText();
    }
}
