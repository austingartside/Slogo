package View;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DisplayOptions implements Placeable{
    
    private Button options;
    private List<String> images;
    private List<Color> colors;
    private VBox vbColors;
    private VBox vbImages;
    
    public DisplayOptions(){
        options = new Button("Display Options");
        options.setMaxWidth(Double.MAX_VALUE);
        setColors();
        setImages();
        setScreen();
    }
    
    public DisplayOptions(List<String> ims,List<Color> cols){
        options = new Button("Display Options");
        options.setMaxWidth(Double.MAX_VALUE);
        colors = cols;
        images = ims;
        setScreen();
    }
    
    public Node getView(){
        return options;
    }
    
    public HBox setScreen(){
        HBox hb = new HBox();
        
        vbColors = new VBox();
        vbImages = new VBox();
        
        showColors();
        showImages();
        
        hb.getChildren().addAll(vbColors,vbImages);
        hb.setSpacing(100);
        
        return hb;
    }
    
    public void setOptionAction(EventHandler<ActionEvent> a){
        options.setOnAction(a);
    }
    
    public void setColors(List<Color> c){
        colors = c;
    }
    public void setImages(List<String> s){
        images = s;
    }
    
    public List<Color> getColors(){
        return colors;
    }
    
    public List<String> getImages(){
        return images;
    }
    
    public Color getColor(double i){
        return colors.get((int)i);
    }
    
    public String getImage(double i){
        return images.get((int)i);
    }
    
    public void addColor(Color c){
        colors.add(c);
        setupColor(colors.size()-1);
    }
    
    public void addImage(String i){
        images.add(i);
        setupImage(images.size()-1);
    }
    
    public int getColorIndex(Color c){
        if(colors.contains(c)){
            return colors.indexOf(c);
        }else{
            addColor(c);
            return colors.indexOf(c);
        }
    }
    
    public int getImageIndex(String s){
        if(images.contains(s)){
            return images.indexOf(s);
        }else{
            addImage(s);
            return images.indexOf(s);
        }
    }
    
    private void setColors(){
        colors = new ArrayList<>();
        colors.add(Color.BLACK);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        colors.add(Color.MAGENTA);
        colors.add(Color.PINK);
        colors.add(Color.ORANGE);
        colors.add(Color.PURPLE);
        colors.add(Color.WHITE);
    }
    
    private void setImages(){
        String path = System.getProperty("user.dir")+"/src/resources.view/";
        images = new ArrayList<>();
        images.add(new File(path+"Turtle.png").toURI().toString());
        images.add(new File(path+"Harambe.jpg").toURI().toString());
        images.add(new File(path+"beachball.jpeg").toURI().toString());
        images.add(new File(path+"michael scott.png").toURI().toString());
    }
    
    private void showColors(){
        vbColors.getChildren().add(new Label("Set Color Options"));
        for(int i = 0; i< colors.size(); i++){
            setupColor(i);
        }
        vbColors.setSpacing(10);
    }
    
    private void showImages(){
        vbImages.getChildren().add(new Label("Set Image Options"));
        for(int i = 0; i< images.size(); i++){
            setupImage(i);
        }
        vbImages.setSpacing(10);
    }
    
    private void setupImage(int i){
        ImageView im  = new ImageView(images.get(i));
        HBox hb = new HBox();
        im.setFitWidth(40);
        im.setFitHeight(40);
        im.setPreserveRatio(true);
        im.setSmooth(true);
        im.setCache(true);
        hb.getChildren().addAll(new Label(Double.toString(i)),im);
        hb.setSpacing(10);
        vbImages.getChildren().add(hb);
    }
    
    private void setupColor(int i){
        HBox hb = new HBox();
        Rectangle r = new Rectangle(0,0,40,40);
        r.setFill(colors.get(i));
        hb.getChildren().addAll(new Label(Double.toString(i)),r);
        hb.setSpacing(10);
        vbColors.getChildren().add(hb);
    }
}
