package View;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import screens.SLogoScene;

public class WorkspaceSaver {
    
    private Button save;
    private SLogoScene myScene;
    private PrintWriter writer;
    
    public WorkspaceSaver(){
        save = new Button("Save Workspace");
        
    }
    
    public Node getView(){
        return save;
    }
    
    public void setSaveAction(EventHandler<ActionEvent> a){
        save.setOnAction(a);
    }
    
    public void saveWorkspace(String fileName,SLogoScene scene, String loadedFile){
        myScene = scene;
        try {
            writer = new PrintWriter(fileName+".txt", "UTF-8");
            writeColorList();
            writeImageList();
            writer.println(scene.getSettingTools().getLanguageChooser().getSelectedItem());
            writer.println(loadedFile);
            writer.println(colorToString(scene.getTurtleDisplay().getBackgroundCanvas().getCanvasColor()));
            writer.println(colorToString(scene.getTurtleDisplay().getPenColor()));
            writer.println(scene.getTurtleDisplay().getTurtleImage().getString());
            writer.close();
        }
        catch (FileNotFoundException | UnsupportedEncodingException e) {
            scene.showError("Cannot write to file");
        }
    }
    
    private void writeColorList(){
        List<Color> colors = myScene.getHelpTools().getDisplayOptions().getColors();
        for(Color c : colors){
            writer.print(colorToString(c) + " ");
        }
        writer.println("");
    }
    
    private void writeImageList(){
        List<String> images = myScene.getHelpTools().getDisplayOptions().getImages();
        for(String im : images){
            writer.print(im + " ");
        }
        writer.println("");
    }
    
    private String colorToString(Color c){
        return String.format( "%02X%02X%02X",
                              (int)( c.getRed() * 255 ),
                              (int)( c.getGreen() * 255 ),
                              (int)( c.getBlue() * 255 ) );
    }
}
