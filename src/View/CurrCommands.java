package View;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class CurrCommands extends ButtonGenerator{
    private ListView<String> listView;
    public CurrCommands(){
        listView = new ListView<>();
    }
    @Override
    public ListView<String> create(){
        control = listView;
        return listView;
    }
    public void execute(){

    }
    public ListView<String> getListView(){
        return listView;
    }
}
