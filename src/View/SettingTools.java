package View;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class SettingTools implements Placeable {
    private ToolBar toolBar;
    private ColorPicker penColorPicker;
    private ColorPicker backgroundColorPicker;
    private LanguageChooser languageChooser;
    private Button imageChanger;
    private TurtleSpeed turtleSpeed;
    private ComboBox<Enum> lineChanger;
    private ComboBox<Enum> penStatus;
    
    public SettingTools(){
        languageChooser = new LanguageChooser();
        penColorPicker = new ColorPicker();
        turtleSpeed = new TurtleSpeed();
        backgroundColorPicker = new ColorPicker();
        imageChanger = new Button("Change Image");
        lineChanger = new ComboBox<>();
        lineChanger.setPromptText("SOLID");
        penStatus = new ComboBox<>();
        penStatus.setPromptText("PENDOWN");
        addPenStatusOptions();
        addLineOptions();
        toolBar = new ToolBar();
        toolBar.getItems().add(addButtonToBar((ComboBox<String>)languageChooser.getView()));
        toolBar.getItems().add(addColorPickerToBar(penColorPicker,"Pen Color"));
        toolBar.getItems().add(addColorPickerToBar(backgroundColorPicker,"Background Color"));
        toolBar.getItems().add(addButtonToBar(imageChanger));
        toolBar.getItems().add(addButtonToBar(lineChanger));
        toolBar.getItems().add(addButtonToBar(penStatus));
        toolBar.getItems().add(addButtonToBar((ComboBox<String>)turtleSpeed.getView()));
    }

    public void setBackgroundAction(EventHandler<ActionEvent> a){
        backgroundColorPicker.setOnAction(a);
    }
    
    public void setPenAction(EventHandler<ActionEvent> a){
        penColorPicker.setOnAction(a);
    }
    
    public void setLanguageAction(EventHandler<ActionEvent> a){
        ComboBox<String> comboBox = (ComboBox<String>)languageChooser.getView();
        comboBox.setOnAction(a);
    }
    public void setTurtleSpeedAction(EventHandler<ActionEvent> a){
        ComboBox<String> comboBox = (ComboBox<String>)turtleSpeed.getView();
        comboBox.setOnAction(a);
    }

    public Enum getLineChoice(){
        return lineChanger.getSelectionModel().getSelectedItem();
    }
    public Enum getPenStatusChoice(){
        return penStatus.getSelectionModel().getSelectedItem();
    }
    public void setPenStatusAction(EventHandler<ActionEvent> a){
        penStatus.setOnAction(a);
    }
    public void setLineChangerAction(EventHandler<ActionEvent> a){
        lineChanger.setOnAction(a);
    }
    public void setImageAction(EventHandler<ActionEvent> a){
        imageChanger.setOnAction(a);
    }
    
    public ColorPicker getBackgroundColorPicker(){
        return backgroundColorPicker;
    }
    public TurtleSpeed getTurtleSpeed(){
        return turtleSpeed;
    }
    
    public ColorPicker getPenColorPicker(){
        return penColorPicker;
    }
    
    public LanguageChooser getLanguageChooser(){
        return languageChooser;
    }

    private void addLineOptions(){
        lineChanger.getItems().add(TurtleDisplay.LineType.DASH);
        lineChanger.getItems().add(TurtleDisplay.LineType.SOLID);
        lineChanger.getItems().add(TurtleDisplay.LineType.DOTTED);
    }
    private void addPenStatusOptions(){
        penStatus.getItems().add(TurtleDisplay.PenStatus.PENUP);
        penStatus.getItems().add(TurtleDisplay.PenStatus.PENDOWN);
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
    
    public Node getView(){
        return toolBar;
    }
}
