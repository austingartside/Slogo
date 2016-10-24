package View;
import java.io.File;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.control.*;

/**
 * Created by Bill Xiong on 10/19/16.
 * Generates and updates the display. Should not interact with backend
 */

public class DisplayGenerator {

    static final int ADJUST = 150;
    
    private GridPane gridPane;
    
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
    public GridPane setScene(List<Control> toolbar,List<ListViewNamer> listViews,TextArea commandLine,
                             ImageView turtle, CanvasGenerator canvas, ComboBox<String> languages,
                             List<Button> buttons) throws Exception{
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
        
        addListViews(listViews);
        addCommandInput(commandLine,findButton(buttons, "Enter"),findButton(buttons, "Clear"));
        addCanvas(canvas);
        addButtons(languages,toolbar);
        addImage(turtle);
        addHelp(findButton(buttons,"Help"));
        return gridPane;
    }
    
    private Button findButton(List<Button> btns, String label) throws Exception{
        for(Button btn : btns){
            if(btn.getText() == label){
                return btn;
            }
        }
        throw new Exception();
    }

    /**
     * Use this method to add an event handler to the button that will process text and send
     * to the backend.
     * @return the submit button to submit the command to the backend
     */
    private void addLanguages(ComboBox<String> languages){
        languages.setPromptText("Choose Language");
        languages.setMaxWidth(Double.MAX_VALUE);
        languages.setMaxHeight(Double.MAX_VALUE);
        languages.getItems().addAll("English","Chinese","French","German","Italian","Portugese","Russian","Spanish");
        gridPane.add(languages, 14, 18, 4, 2);
    }
    private void addImage(ImageView turtle){
        turtle.setTranslateX(CanvasGenerator.CANVAS_X/2 + 0);
        turtle.setTranslateY(CanvasGenerator.CANVAS_Y/2 + ADJUST + 0);
        turtle.setFitWidth(40);
        turtle.setFitHeight(40);
        turtle.setPreserveRatio(true);
        turtle.setSmooth(true);
        turtle.setCache(true);
        gridPane.getChildren().add(turtle);
    }
    private void addButtons(ComboBox<String> languages, List<Control> tb){
        addLanguages(languages);
        formatButtons(tb);
    }
    
    private void formatButtons(List<Control> tb){
        HBox hb = new HBox();
        hb.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        for(Control c : tb){
            if(c instanceof ColorPicker){
                hb.getChildren().add(addColorPickerToBar(((ColorPicker)c),((ColorPicker)c).getPromptText()));
            }else{
                hb.getChildren().add(addButtonToBar(c));
            }
        }
        gridPane.add(hb, 0, 0, 12, 3);
        hb.setSpacing(10);
    }
    
    private VBox addColorPickerToBar(ColorPicker cp, String label){
        VBox vb = new VBox();
        Label l = new Label(label);
        HBox.setHgrow(vb, Priority.ALWAYS);
        cp.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        VBox.setVgrow(cp, Priority.ALWAYS);
        vb.getChildren().addAll(l,cp);
        vb.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        return vb;
    }
    
    private VBox addButtonToBar(Control b){
        VBox vb = new VBox();
        Label placeHold = new Label("");
        HBox.setHgrow(vb, Priority.ALWAYS);
        b.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        VBox.setVgrow(b, Priority.ALWAYS);
        vb.getChildren().addAll(placeHold,b);
        vb.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        return vb;
    }
    private TextArea addCommandInput(TextArea commandLine, Button enter, Button clear){
        Label label1 = new Label("Command:");
        VBox vb = new VBox();
        vb.getChildren().addAll(enter,clear);
        vb.setSpacing(10);
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, commandLine, vb);
        hb.setSpacing(10);
        gridPane.add(hb,0,18,12,2);
        return commandLine;
    }
    
    private Canvas addCanvas(CanvasGenerator canvas){
        Canvas can = canvas.createCanvas();
        gridPane.add(can, 0, 2, 12, 16);
        return can;
    }
    
    private void addListViews(List<ListViewNamer> listViews){
        TabPane tabs = new TabPane();
        for(ListViewNamer lv : listViews){
            Tab tab = new Tab();
            tab.setText(lv.getName());
            tab.setContent(lv.getListView());
            tabs.getTabs().add(tab);
        }
        gridPane.add(tabs, 12, 1, 8, 17);
    }
    
    private void addHelp(Button help){
        help.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent ae){
                displayHelp();
            }
        });
        help.setMaxWidth(Double.MAX_VALUE);
        gridPane.add(help, 18, 0, 2, 1);
    }
    //all the event handlers for comboboxes
    private void displayHelp(){
        String path = System.getProperty("user.dir");
        path += "/src/help.html";
        WebView web = new WebView();
        web.getEngine().load("file:///" + path);
        Stage s = new Stage();
        Scene scene = new Scene(web);
        scene.setRoot(web);
        s.setScene(scene);
        s.show();
    }
}