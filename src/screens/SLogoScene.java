package screens;

import java.util.ResourceBundle;
import View.CanvasGenerator;
import View.CommandBar;
import View.DisplayGenerator;
import View.HelpButton;
import View.HelpTabs;
import View.SettingTools;
import View.TurtleDisplay;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class SLogoScene extends ActionScene{
    
    public static final int SIZE_X = 1200;
    public static final int SIZE_Y = 700;
    public static final int COLUMNS = 20;
    
    private GridPane gridPane;
    private TurtleDisplay turtleDisplay;
    private CommandBar commandBar;
    private HelpTabs helpTabs;
    private SettingTools settingTools;
    private HelpButton helpButton;

    public SLogoScene(Scene scene, ResourceBundle resource) throws Exception{
        super(scene, resource, SIZE_Y, SIZE_X);
        
        //Controller control=new Controller();
        commandBar = new CommandBar();
        helpButton = new HelpButton();
        helpTabs = new HelpTabs();
        settingTools = new SettingTools();
        turtleDisplay = new TurtleDisplay();
        helpTabs.getCurrState().addCurrState(0, 0, 0, 0, CanvasGenerator.DEFAULT, 0);
        //control.setUp();
        setScene();
    }
    
    public void setScene() throws Exception{
        DisplayGenerator dg = new DisplayGenerator();
        dg.setGridPane(COLUMNS);
        gridPane = dg.setScene(this);
        myScene = new Scene(gridPane, SIZE_X,SIZE_Y);
    }
    public CommandBar getCommandBar(){
        return commandBar;
    }
    public TurtleDisplay getTurtleDisplay(){
        return turtleDisplay;
    }
    public SettingTools getSettingTools(){
        return settingTools;
    }
    public HelpButton getHelpButton(){
        return helpButton;
    }
    public HelpTabs getHelpTabs(){
        return helpTabs;
    }
}
