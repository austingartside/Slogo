package screens;

import java.io.File;
import java.util.ResourceBundle;
import View.*;
import ViewLogic.WorkspaceParser;
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
    private HelpTools helpTools;
    private WorkspaceParser workspaceParser;

    public SLogoScene(Scene scene, ResourceBundle resource){
        super(scene, resource, SIZE_Y, SIZE_X);
        workspaceParser = null;
        init();
    }

    public SLogoScene(Scene scene, ResourceBundle resource,File file){
        super(scene, resource, SIZE_Y, SIZE_X);
        workspaceParser = new WorkspaceParser(file);
        init();
    }
    
    private void init(){
        helpTools = new HelpTools();
        commandBar = new CommandBar();
        helpTabs = new HelpTabs();
        settingTools = new SettingTools();
        turtleDisplay = new TurtleDisplay(1);
        helpTools.getDebugger().push(turtleDisplay);
        helpTabs.getCurrState().addCurrState(0, 0, 0, 0, CanvasGenerator.DEFAULT, 0);
        setScene();
    }
    
    public void setScene(){
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
    public HelpTabs getHelpTabs(){
        return helpTabs;
    }
    public WorkspaceParser getWorkspaceParser(){
        return workspaceParser;
    }
    public HelpTools getHelpTools(){
        return helpTools;
    }
    
}
