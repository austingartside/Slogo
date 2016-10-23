package screens;

import java.util.ResourceBundle;
import View.DisplayGenerator;
import ViewLogic.DisplayUpdater;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import model.Controller;

public class SLogoScene extends ActionScene{
    private DisplayUpdater updater;
    
    public SLogoScene(Scene scene, ResourceBundle resource, int height, int width,Controller control){
        super(scene, resource, height, width);
        updater = new DisplayUpdater(MainMenu.displayGenerator,control);
        updater.setUp();
    }
    public DisplayUpdater getUpdater(){
        return updater;
    }
}
