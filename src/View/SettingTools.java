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

public class SettingTools {
    private ToolBar toolBar;
    private ColorPicker penColorPicker;
    private ColorPicker backgroundColorPicker;
    private LanguageChooser languageChooser;
    private Button imageChanger;
    private ComboBox<Enum> lineChanger;
    public SettingTools(){
        languageChooser = new LanguageChooser();
        penColorPicker = new ColorPicker();
        backgroundColorPicker = new ColorPicker();
        imageChanger = new Button("Change Image");
        lineChanger = new ComboBox<>();
        lineChanger.setPromptText("SOLID");
        addLineOptions();
        toolBar = new ToolBar();
        toolBar.getItems().add(addButtonToBar((ComboBox<String>)languageChooser.getView()));
        toolBar.getItems().add(addColorPickerToBar(penColorPicker,"Pen Color"));
        toolBar.getItems().add(addColorPickerToBar(backgroundColorPicker,"Background Color"));
        toolBar.getItems().add(addButtonToBar(imageChanger));
        toolBar.getItems().add(addButtonToBar(lineChanger));
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

    public Enum getLineChoice(){
        return lineChanger.getSelectionModel().getSelectedItem();
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
