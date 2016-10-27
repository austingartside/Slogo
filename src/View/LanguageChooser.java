package View;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;

public class LanguageChooser {
    
    public static final String[] LANGUAGES = {"English","Chinese","French","German","Italian","Portugese","Russian","Spanish"};
    
    private ComboBox<String> lang;
    
    public LanguageChooser(){
        lang = new ComboBox<String>();
        lang.setPromptText("English");
        setupLangs();
    }
    
    private void setupLangs(){
        for(String s : LANGUAGES){
            lang.getItems().add(s);
        }
    }
    
    public String getSelectedItem(){
        return lang.getSelectionModel().getSelectedItem();
    }
    
    public Node getView(){
        return lang;
    }
}
