package View;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import screens.SLogoScene;
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
    public GridPane setScene(SLogoScene scene) {
        addListViews(scene.getHelpTabs());
        addCommandInput(scene.getCommandBar());
        addTurtleDisplay(scene.getTurtleDisplay());
        addHelpTools(scene.getHelpTools());
        addToolBar(scene.getSettingTools());
        
        return gridPane;
    }

    /**
     * Use this method to add an event handler to the button that will process text and send
     * to the backend.
     * @return the submit button to submit the command to the backend
     */
    private void addToolBar(SettingTools st){
        ((ToolBar)st.getView()).setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        gridPane.add(st.getView(), 0, 0, 12, 3);
    }
    
    private void addCommandInput(CommandBar commandBar){
        gridPane.add(commandBar.getView(),0,18,12,2);
    }
    
    private void addTurtleDisplay(TurtleDisplay td){
        gridPane.add(td.getView(), 0, 2, 12, 16);
    }
    
    private void addListViews(HelpTabs ht){
        ht.getCurrState().addCurrState(0, 0, 0, 0, CanvasGenerator.DEFAULT, 0);
        gridPane.add(ht.getView(), 12, 1, 8, 19);
    }
    
    private void addHelpTools(HelpTools helpTools){
        gridPane.add(helpTools.getView(), 12, 0, 8, 1);
    }
    //all the event handlers for comboboxes

}