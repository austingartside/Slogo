package screens;

import java.io.File;
import java.util.ResourceBundle;
import View.CanvasGenerator;
import View.CommandBar;
import View.DisplayGenerator;
import View.DisplayOptions;
import View.FileControl;
import View.HelpButton;
import View.HelpTabs;
import View.SettingTools;
import View.TurtleDisplay;
import View.WorkspaceParser;
import View.*;
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
    private FileControl fileControl;
    private DisplayOptions displayOptions;
    private WorkspaceParser workspaceParser;
    private Debugger debugger;

    public SLogoScene(Scene scene, ResourceBundle resource){
        super(scene, resource, SIZE_Y, SIZE_X);
        
        //Controller control=new Controller();
        displayOptions = new DisplayOptions();
        debugger = new Debugger();
        fileControl = new FileControl();
        commandBar = new CommandBar();
        helpButton = new HelpButton();
        helpTabs = new HelpTabs();
        settingTools = new SettingTools();
        turtleDisplay = new TurtleDisplay(1);
        helpTabs.getCurrState().addCurrState(0, 0, 0, 0, CanvasGenerator.DEFAULT, 0);
        //control.setUp();
        setScene();
    }

    public SLogoScene(Scene scene, ResourceBundle resource,File file){
        super(scene, resource, SIZE_Y, SIZE_X);
        displayOptions = new DisplayOptions(file);
        fileControl = new FileControl();
        commandBar = new CommandBar();
        helpButton = new HelpButton();
        helpTabs = new HelpTabs();
        settingTools = new SettingTools();
        turtleDisplay = new TurtleDisplay(1);
    }
    
    public void setScene(){
        DisplayGenerator dg = new DisplayGenerator();
        dg.setGridPane(COLUMNS);
        gridPane = dg.setScene(this);
        myScene = new Scene(gridPane, SIZE_X,SIZE_Y);
    }
    public Debugger getDebugger(){
        return debugger;
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
    public FileControl getFileControl(){
        return fileControl;
    }
    public DisplayOptions getDisplayOptions(){
        return displayOptions;
    }
    
}
