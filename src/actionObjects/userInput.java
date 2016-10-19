package actionObjects;

import javafx.scene.control.TextField;

public class userInput {
    
    private TextField textField;
    
    public userInput(){
        
        textField = new TextField();
        
    }
    
    public void setInput(String s){
        textField.setText(s);
    }

}
