package View;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Translate;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import screens.SLogoScene;
import javafx.scene.control.*;

/**
 * Created by Bill Xiong on 10/19/16.
 * Generates and updates the display. Should not interact with backend
 */

public class DisplayGenerator {

    static final int ADJUST = 150;
    
    private GridPane gridPane;
    private SLogoScene myScene;
    
    public void setGridPane(int columns){
        gridPane = new GridPane();
        gridPane.setHgap(10); 
        gridPane.setVgap(10); 
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        for(int i = 0; i < columns; i++){
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(10);
            gridPane.getColumnConstraints().add(column);

            RowConstraints row = new RowConstraints();
            row.setPercentHeight(10);
            gridPane.getRowConstraints().add(row);
        }
    }

    /**
     * This method adds all necessary components to the front end.
     * TODO add a turtle image here. Will do this once Gunhan/Austin makes getter for image.
     * @throws Exception 
     */
    public GridPane setScene(SLogoScene scene) throws Exception{
/*        Button test = new Button("move turtle");
        test.setOnAction((event)->{
            drawTurtle(50, 0);
        });
        Button rotate = new Button("rotate");
        rotate.setTranslateY(50);
        rotate.setOnAction((event)->{
            rotateTurtle(50);
        });*/
      /*  Button draw = new Button("draw");
        draw.setOnAction((event)->{
            drawLine(0, 0, 50, 0);
        });*/
/*        gridPane.getChildren().add(test);
        gridPane.getChildren().add(rotate);*/
       /* gridPane.getChildren().add(draw);*/
        
        myScene = scene;
        
        addListViews(scene.getHelpTabs());
        addCommandInput(scene.getCommandBar());
        addTurtleDisplay(scene.getTurtleDisplay());
        addHelp(scene.getHelpButton());
        addToolBar(scene.getSettingTools());

        return gridPane;
    }

    /**
     * Use this method to add an event handler to the button that will process text and send
     * to the backend.
     * @return the submit button to submit the command to the backend
     */
    
    private void addToolBar(SettingTools st){
        ((ToolBar)st.getView()).setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        gridPane.add(st.getView(), 0, 0, 12, 3);
    }
    
    private void addCommandInput(CommandBar commandBar){
        gridPane.add(commandBar.getView(),0,18,12,2);
    }
    
    private void addTurtleDisplay(TurtleDisplay td){
        canvasBoundsMath(td.getLineCanvas());
        canvasBoundsMath(td.getBackgroundCanvas());
        gridPane.add(td.getView(), 0, 2, 12, 16);
    }
    
    private void canvasBoundsMath(CanvasGenerator canvas){
        canvas.setBounds((SLogoScene.SIZE_Y+CanvasGenerator.CANVAS_Y)/2,(SLogoScene.SIZE_Y-CanvasGenerator.CANVAS_Y)/2,
                         gridPane.getPadding().getLeft()+CanvasGenerator.CANVAS_X,gridPane.getPadding().getLeft());
    }
    
    private void addListViews(HelpTabs ht){
        gridPane.add(ht.getView(), 12, 1, 8, 19);
    }
    
    private void addHelp(HelpButton helpButton){
        gridPane.add(helpButton.getView(), 18, 0, 2, 1);
    }
    //all the event handlers for comboboxes

}