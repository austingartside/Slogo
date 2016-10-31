package View;

import javafx.scene.Node;
import javafx.scene.control.ToolBar;

public class HelpTools {
    
    private HelpButton helpButton;
    private FileControl fileControl;
    private DisplayOptions displayOptions;
    private ToolBar toolBar;
    private WorkspaceSaver workspaceSaver;
    
    public HelpTools(){
        toolBar = new ToolBar();
        helpButton = new HelpButton();
        fileControl = new FileControl();
        displayOptions = new DisplayOptions();
        workspaceSaver = new WorkspaceSaver();
        toolBar.getItems().addAll(helpButton.getView(),fileControl.getView(),displayOptions.getView(),workspaceSaver.getView());
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
}
