package View;

import java.util.HashMap;
import com.sun.javafx.collections.MappingChange.Map;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class TurtleSpeed implements Placeable{
    public static final String[] SPEEDS = {"Fast","Medium", "Slow"};
    public static final String DEFAULT = "Medium";
    
    private HashMap<String,Integer> speed;
    private String currSpeed;
    private ComboBox<String> turtleSpeed;
    
    public TurtleSpeed(){
        currSpeed = DEFAULT;
        speed = new HashMap<String,Integer>();
        turtleSpeed = new ComboBox<String>();
        turtleSpeed.setPromptText(DEFAULT);
        setupSpeeds();
    }
    
    private void setupSpeeds(){
        int i = 0;
        for(String s : SPEEDS){
            turtleSpeed.getItems().add(s);
            speed.put(s, 1+i*1000);
            i++;
        }
    }
    
    public String getSelectedItem(){
        return currSpeed;
    }
    
    public Node getView(){
        return turtleSpeed;
    }

    public int getSpeed(){
        currSpeed = turtleSpeed.getSelectionModel().getSelectedItem();
        return speed.get(currSpeed);
    }
}
