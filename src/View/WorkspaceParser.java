package View;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import javafx.scene.paint.Color;

public class WorkspaceParser {
    
    private File file;
    
    public WorkspaceParser(File f){
        file = f;
        parse();
    }
    
    public List<Color> getColorList(){
        return null;    
    }
    
    public List<String> getImageList(){
        return null;
    }
    
    public File getFiletoLoad(){
        return null;
    }
    
    public Color getBackgroundColor(){
        return null;
    }
    
    public Color getPenColor(){
        return null;
    }
    
    public Color getPenLine(){
        return null;
    }
    
    private void parse(){
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.startsWith("colors")){
                
            }
        }
    }
}
