package View;

import javafx.scene.Node;
import javafx.scene.control.ToolBar;

public class HelpTools {
    
    private HelpButton helpButton;
    private FileControl fileControl;
    private DisplayOptions displayOptions;
    private ToolBar toolBar;
    
    public HelpTools(){
        toolBar = new ToolBar();
        helpButton = new HelpButton();
        fileControl = new FileControl();
        displayOptions = new DisplayOptions();
        toolBar.getItems().addAll(helpButton.getView(),fileControl.getView(),displayOptions.getView());
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
}
