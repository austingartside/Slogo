package View;

import ViewLogic.WorkspaceSaver;
import javafx.scene.Node;
import javafx.scene.control.ToolBar;

public class HelpTools implements Placeable{
    
    private HelpButton helpButton;
    private FileControl fileControl;
    private DisplayOptions displayOptions;
    private ToolBar toolBar;
    private WorkspaceSaver workspaceSaver;
    public Debugger debugger;
    
    public HelpTools(){
        toolBar = new ToolBar();
        helpButton = new HelpButton();
        fileControl = new FileControl();
        displayOptions = new DisplayOptions();
        workspaceSaver = new WorkspaceSaver();
        debugger = new Debugger();
        toolBar.getItems().addAll(helpButton.getView(),fileControl.getView(),displayOptions.getView(),workspaceSaver.getView(),debugger.getView());
    }
    
    public Node getView(){
        return toolBar;
    }
    

    public FileControl getFileControl(){
        return fileControl;
    }
    public DisplayOptions getDisplayOptions(){
        return displayOptions;
    }
    public HelpButton getHelpButton(){
        return helpButton;
    }
    public WorkspaceSaver getWorkspaceSaver(){
        return workspaceSaver;
    }
    public Debugger getDebugger(){
        return debugger;
    }
}
