package ViewLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class WorkspaceParser {
    
    private File file;
    private List<Color> colorList;
    private List<String> imageList;
    private String filetoLoad;
    private Color backgroundColor;
    private Color penColor;
    private String language;
    private String image;
    
    public WorkspaceParser(File f){
        file = f;
        try {
            parse();
        }
        catch (FileNotFoundException e) {
            //CHANGE LATER
            System.out.println("FILE WAS NOT FOUND");
        }
    }
    
    public List<Color> getColorList(){
        return colorList;    
    }
    
    public List<String> getImageList(){
        return imageList;
    }
    
    public String getFiletoLoad(){
        return filetoLoad;
    }
    
    public Color getBackgroundColor(){
        return backgroundColor;
    }
    
    public Color getPenColor(){
        return penColor;
    }
    
    public String getImage(){
        return image;
    }
    
    public String getLanguage(){
        return language;
    }
    
    public void parse() throws FileNotFoundException{
        Scanner sc = new Scanner(file);
        makeColorList(sc.nextLine());
        makeImageList(sc.nextLine());
        makeLanguage(sc.nextLine());
        makeFiletoLoad(sc.nextLine());
        makeBackgroundColor(sc.nextLine());
        makePenColor(sc.nextLine());
        makeImage(sc.nextLine());
        sc.close();
    }

    private void makeImage (String nextLine) {
        image = nextLine.trim();
    }

    private void makeLanguage (String nextLine) {
        language = nextLine.trim();
    }

    private void makePenColor (String nextLine) {
        penColor = makeColor(nextLine.trim());
    }

    private void makeBackgroundColor (String nextLine) {
        backgroundColor = makeColor(nextLine.trim());
        
    }

    private void makeFiletoLoad (String nextLine) {
        filetoLoad = nextLine.trim();
    }

    private void makeImageList (String nextLine) {
        imageList = new ArrayList<String>();
        for(String image: nextLine.split(" ")){
            imageList.add(image);
        }
        
    }

    private void makeColorList (String nextLine) {
        colorList = new ArrayList<Color>();
        for(String color: nextLine.split(" ")){
            colorList.add(makeColor(color));
        }
    }
    
    private Color makeColor(String colorString){
        int red = Integer.parseInt(colorString.substring(0,2), 16);
        int green = Integer.parseInt(colorString.substring(2,4), 16);
        int blue = Integer.parseInt(colorString.substring(4,6), 16);
        return Color.rgb(red, green, blue);
    }
}
