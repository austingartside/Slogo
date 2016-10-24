package View;

import javafx.scene.control.ListView;

public class ListViewNamer {
    private ListView<String> view;
    private String name;
    
    public ListViewNamer(String n){
        name = n;
        view = new ListView<String>();
    }
    
    public String getName(){
        return name;
    }
    
    public ListView<String> getListView(){
        return view;
    }
}
