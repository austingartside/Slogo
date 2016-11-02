package View;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;

public class LanguageChooser implements Placeable{
    
    public static final String[] LANGUAGES = {"English","Chinese","French","German","Italian","Portugese","Russian","Spanish"};
    public static final String DEFAULT = "English";
    
    private String language;
    private ComboBox<String> lang;
    
    public LanguageChooser(){
        language = DEFAULT;
        //lang = new ComboBox<String>();
        lang = new ComboBox<>();
        lang.setPromptText(DEFAULT);
        setupLangs();
    }
    
    private void setupLangs(){
        for(String s : LANGUAGES){
            lang.getItems().add(s);
        }
    }
    
    public String getSelectedItem(){
        return language;
    }
    
    public Node getView(){
        return lang;
    }

    public void setLanguage(){
        language = lang.getSelectionModel().getSelectedItem();
    }
    
    public void setLanguage(String s){
        language = s;
        lang.getSelectionModel().select(s);
    }
}
